package com.onto.javacourse.exceptions;

import com.onto.javacourse.between0n100.NumberOutOtRangeException;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
  @Test
  void testValidInput()  {
    String input = "50";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    int result = Reader.readNumber();
    assertEquals(50, result);
  }

  @Test
  void testInputBelowRange() {
    String input = "-10";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Exception exception = assertThrows(NumberOutOtRangeException.class, Reader::readNumber);
    assertEquals("Number must be between 0 and 100", exception.getMessage());
  }

  @Test
  void testInputAboveRange() {
    String input = "150";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Exception exception = assertThrows(NumberOutOtRangeException.class, Reader::readNumber);
    assertEquals("Number must be between 0 and 100", exception.getMessage());
  }

  @Test
  void testInvalidInput() {
    String input = "abc";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Exception exception = assertThrows(NumberFormatException.class, Reader::readNumber);
    assertEquals("Not an integer", exception.getMessage());
  }
}
