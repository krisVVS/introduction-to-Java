package com.onto.javacourse;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.onto.javacourse.displayer.Displayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DisplayerTest {

  private TestLogAppender logAppender;

  @BeforeEach
  void setUp() {
    Logger LOGGER = (Logger) LoggerFactory.getLogger(Displayer.class);
    logAppender = new TestLogAppender();
    logAppender.start();
    LOGGER.addAppender(logAppender);
  }

  @Test
  void testReturnClassDetails_withNullInstance() {
    Displayer.returnClassDetails(null);
    assertTrue(logAppender.contains("Provided instance is null. Cannot display class details.", "WARN"));
  }

  @Test
  void testReturnClassDetails_withAccessibleFieldsAndMethods() {
    TestClass instance = new TestClass(123, "Test String");
    Displayer.returnClassDetails(instance);
    assertTrue(logAppender.contains("Class: com.onto.javacourse.DisplayerTest$TestClass", "INFO"));
    assertTrue(logAppender.contains("public int value = 123", "INFO"));
    assertTrue(logAppender.contains("private String text = Test String", "INFO"));
    assertTrue(logAppender.contains("public int getValue()", "INFO"));
    assertTrue(logAppender.contains("public void setValue(int)", "INFO"));
  }

  @Test
  void testReturnClassDetails_withInaccessibleField() {
    TestClass instance = new TestClass(123, "Test String");
    Displayer.returnClassDetails(instance);
    assertTrue(logAppender.contains("public int value = 123", "INFO"));
    assertTrue(logAppender.contains("private String text = Test String", "INFO"));
  }


  @Test
  void testReturnClassDetails_withEmptyClass() {
    EmptyClass instance = new EmptyClass();
    Displayer.returnClassDetails(instance);
    assertTrue(logAppender.contains("Class: com.onto.javacourse.DisplayerTest$EmptyClass", "INFO"));
    assertTrue(logAppender.contains("Fields:", "INFO"));
    assertTrue(logAppender.contains("Methods:", "INFO"));
  }

  private static class TestClass {
    public int value;
    private String text;

    public TestClass(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
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
          .anyMatch(log -> log.getFormattedMessage().contains(message) &&
              log.getLevel().toString().equalsIgnoreCase(level));
    }
  }
}
