package com.onto.javacourse.inputoutput.consolereader;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {

  @Test
  void testReadString_ValidInput() {
    String input = "hello"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    String result = reader.readString();
    assertEquals("hello", result);
  }

  @Test
  void testReadInt_ValidInput() {
    String input = "42"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    int result = reader.readInt();
    assertEquals(42, result);
  }

  @Test
  void testReadInt_InvalidThenValidInput() {
    String input = "notANumber"+System.lineSeparator()+"123"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    int result = reader.readInt();
    assertEquals(123, result);
  }

  @Test
  void testReadChar_ValidInput() {
    String input = "a"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    char result = reader.readChar();
    assertEquals('a', result);
  }

  @Test
  void testReadChar_InvalidThenValidInput() {
    String input = "abc"+System.lineSeparator()+"x"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    char result = reader.readChar();
    assertEquals('x', result);
  }

  @Test
  void testReadFloat_ValidInput() {
    String input = "3.14"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    float result = reader.readFloat();
    assertEquals(3.14f, result);
  }

  @Test
  void testReadFloat_InvalidThenValidInput() {
    String input = "pi"+System.lineSeparator()+"2.71"+System.lineSeparator();
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    float result = reader.readFloat();
    assertEquals(2.71f, result);
  }
}
