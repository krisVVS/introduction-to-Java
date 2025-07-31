package com.onto.javacourse.synchronizedthreads;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

public class CounterSynchronizedTest {

  private ListAppender<ILoggingEvent> listAppender;

  @BeforeEach
  void setup() {
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    ch.qos.logback.classic.Logger logger =
        context.getLogger(CounterSynchronized.class);
    listAppender = new ListAppender<>();
    listAppender.start();
    logger.addAppender(listAppender);
  }

  @Test
  void testThreadWithDifferentMax() throws InterruptedException {
    Thread t1 = new Thread(new CounterSynchronized("ThreadA", 2, 30));
    Thread t2 = new Thread(new CounterSynchronized("ThreadB", 4, 30));

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    List<String> logs = new ArrayList<>();
    for (ILoggingEvent event : listAppender.list) {
      logs.add(event.getFormattedMessage());
    }

    assertTrue(logs.contains("ThreadB - 4"));
    assertTrue(logs.indexOf("ThreadA - 2") < logs.indexOf("ThreadB - 3"));
  }
}
