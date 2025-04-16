package com.onto.javacourse.inputoutput.consolereader;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {

  @Test
  void testReadString_ValidInput() {
    String input = "hello\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    String result = reader.readString();
    assertEquals("hello", result);
  }

  @Test
  void testReadInt_ValidInput() {
    String input = "42\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    int result = reader.readInt();
    assertEquals(42, result);
  }

  @Test
  void testReadInt_InvalidThenValidInput() {
    String input = "notANumber\n123\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    int result = reader.readInt();
    assertEquals(123, result);
  }

  @Test
  void testReadChar_ValidInput() {
    String input = "a\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    char result = reader.readChar();
    assertEquals('a', result);
  }

  @Test
  void testReadChar_InvalidThenValidInput() {
    String input = "abc\nx\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    char result = reader.readChar();
    assertEquals('x', result);
  }

  @Test
  void testReadFloat_ValidInput() {
    String input = "3.14\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    float result = reader.readFloat();
    assertEquals(3.14f, result);
  }

  @Test
  void testReadFloat_InvalidThenValidInput() {
    String input = "pi\n2.71\n";
    ConsoleReader reader = new ConsoleReader(new ByteArrayInputStream(input.getBytes()));
    float result = reader.readFloat();
    assertEquals(2.71f, result);
  }
}
