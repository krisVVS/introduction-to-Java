package com.onto.javacourse.displaybyname;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayerByNameTest {

  @Test
  void testValidClassName() {
    assertDoesNotThrow(() -> DisplayerByName.displayerByName("java.util.ArrayList"));
  }

  @Test
  void testNullClassName() {
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> DisplayerByName.displayerByName(null));
    assertTrue(exception.getMessage().contains("Class name cannot be null or empty"));
  }

  @Test
  void testEmptyClassName() {
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> DisplayerByName.displayerByName(""));
    assertTrue(exception.getMessage().contains("Class name cannot be null or empty"));
  }

  @Test
  void testInvalidClassName() {
    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> DisplayerByName.displayerByName("com.nonexistent.ClassName"));
    assertTrue(exception.getMessage().startsWith("Class not found"));
  }

  @Test
  void testClassWithNoParentClass() {
    assertDoesNotThrow(() -> DisplayerByName.displayerByName("java.lang.Object"));
  }
}
