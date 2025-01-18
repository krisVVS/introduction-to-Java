package com.onto.javacourse.displayprivate;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DisplayPrivateTest {

  private TestLogAppender logAppender;

  @BeforeEach
  void setUp() {
    Logger logger = (Logger) LoggerFactory.getLogger(DisplayPrivate.class);
    logAppender = new TestLogAppender();
    logAppender.start();
    logger.addAppender(logAppender);
  }

  @Test
  void testDisplayPrivate_withNullInstance() {
    DisplayPrivate.displayPrivate(null);
    assertTrue(logAppender.contains("Provided instance is null. Cannot display class details.", "WARN"));
  }

  @Test
  void testDisplayPrivate_withPrivateFieldsAndMethods() {
    TestClass instance = new TestClass();

    DisplayPrivate.displayPrivate(instance);

    assertTrue(logAppender.contains("private String privateField = Private Value", "INFO"));
    assertTrue(logAppender.contains("private int privateNumber = 42", "INFO"));

    assertTrue(logAppender.contains("private String privateMethod(): Hello, Private Value", "INFO"));
    assertTrue(logAppender.contains("private void privateVoidMethod(String): [requires parameters]", "INFO"));
  }

  @Test
  void testDisplayPrivate_withEmptyClass() {
    EmptyClass instance = new EmptyClass();
    DisplayPrivate.displayPrivate(instance);
    assertTrue(logAppender.contains("Class: com.onto.javacourse.displayprivate.DisplayPrivateTest$EmptyClass", "INFO"));
    assertTrue(logAppender.contains("Fields:", "INFO"));
    assertTrue(logAppender.contains("Methods:", "INFO"));
  }

  private static class TestClass {
    private String privateField = "Private Value";
    private int privateNumber = 42;
    private String test;

    private String privateMethod() {
      return "Hello, Private Value";
    }

    private void privateVoidMethod(String input) {
    }
  }

  private static class EmptyClass {
  }

  private static class TestLogAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> logs = new ArrayList<>();

    @Override
    protected void append(ILoggingEvent event) {
      logs.add(event);
    }

    boolean contains(String message, String level) {
      return logs.stream()
          .anyMatch(log -> log.getFormattedMessage().contains(message)
              && log.getLevel().toString().equalsIgnoreCase(level));
    }
  }
}
