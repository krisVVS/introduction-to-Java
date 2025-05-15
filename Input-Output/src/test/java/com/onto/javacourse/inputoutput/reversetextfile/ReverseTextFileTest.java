package com.onto.javacourse.inputoutput.reversetextfile;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseTextFileTest {

  private static final String TEST_FILE_PATH = "testFile.txt";

  @Test
  void testReversingFile() throws IOException {
    String originalContent = "Line1"+System.lineSeparator()+"Line2"+System.lineSeparator()+"Line3"+System.lineSeparator();
    File file = new File(TEST_FILE_PATH);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(originalContent);
    }

    ReverseTextFile.reversingFile(TEST_FILE_PATH);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line1 = reader.readLine();
      String line2 = reader.readLine();
      String line3 = reader.readLine();

      assertNotNull(line1);
      assertNotNull(line2);
      assertNotNull(line3);

      assertEquals("Line3", line1);
      assertEquals("Line2", line2);
      assertEquals("Line1", line3);
    }

    file.delete();
  }

  @Test
  void testEmptyFile() throws IOException {
    File file = new File(TEST_FILE_PATH);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write("");
    }

    ReverseTextFile.reversingFile(TEST_FILE_PATH);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = reader.readLine();
      assertNull(line);
    }

    file.delete();
  }

  @Test
  void testFileNotFound() {
    String nonExistingFilePath = "nonExistingFile.txt";
    assertThrows(IOException.class, () -> ReverseTextFile.reversingFile(nonExistingFilePath));
  }
}
