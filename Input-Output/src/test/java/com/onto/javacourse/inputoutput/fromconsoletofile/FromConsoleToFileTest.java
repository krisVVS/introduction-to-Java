package com.onto.javacourse.inputoutput.fromconsoletofile;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FromConsoleToFileTest {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void testWriteToFile() throws IOException {
    File tempFile = File.createTempFile("test", ".txt");
    tempFile.deleteOnExit();

    String simulatedInput = "testfile.txt"+System.lineSeparator()+"Hello, World!"+System.lineSeparator()+"This is a test."+System.lineSeparator()+"."+System.lineSeparator();
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    FromConsoleToFile fromConsoleToFile = new FromConsoleToFile();
    fromConsoleToFile.writeToFile(tempFile.getAbsolutePath());

    try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
      String line1 = reader.readLine();
      String line2 = reader.readLine();
      String line3 = reader.readLine();

      assertEquals("Hello, World!", line2);
      assertEquals("This is a test.", line3);
    }
  }

  @Test
  void testEmptyInput() throws IOException {
    File tempFile = File.createTempFile("test_empty", ".txt");
    tempFile.deleteOnExit();

    String simulatedInput = "test_empty.txt"+System.lineSeparator()+"."+System.lineSeparator();
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    FromConsoleToFile fromConsoleToFile = new FromConsoleToFile();
    fromConsoleToFile.writeToFile(tempFile.getAbsolutePath());

    try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
      reader.readLine();
      assertNull(reader.readLine());
    }
  }

  @Test
  void testResourceClosure() throws IOException {
    File tempFile = File.createTempFile("test_resource", ".txt");
    tempFile.deleteOnExit();

    String simulatedInput = "test_resource.txt"+System.lineSeparator()+"Line 1"+System.lineSeparator()+"."+System.lineSeparator();
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    FromConsoleToFile fromConsoleToFile = new FromConsoleToFile();
    fromConsoleToFile.writeToFile(tempFile.getAbsolutePath());

    try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
      reader.readLine();
      assertEquals("Line 1", reader.readLine());
    }
  }
}