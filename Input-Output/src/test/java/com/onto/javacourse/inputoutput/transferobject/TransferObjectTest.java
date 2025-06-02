package com.onto.javacourse.inputoutput.transferobject;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransferObjectTest {

  private static final String INPUT_FILE = "test-input.txt";
  private static final String OUTPUT_FILE = "test-output.txt";

  @BeforeEach
  public void setUp() throws IOException {
    try (FileOutputStream fos = new FileOutputStream(INPUT_FILE)) {
      String content = "This is a test input stream with some content for transfer.";
      fos.write(content.getBytes());
    }
  }

  @AfterEach
  public void tearDown() {
    new File(INPUT_FILE).delete();
    new File(OUTPUT_FILE).delete();
  }

  @Test
  public void testTransferWithValidInput() throws IOException {
    try (InputStream inputStream = new FileInputStream(INPUT_FILE);
         OutputStream outputStream = new FileOutputStream(OUTPUT_FILE)) {

      TransferObject transferObject = new TransferObject(inputStream, outputStream);

      int bytesTransferred = transferObject.transfer(20, 0);

      assertEquals(20, bytesTransferred);

      try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
        String outputContent = reader.readLine();
        assertEquals("This is a test input", outputContent);
      }

      transferObject.close();
    }
  }

  @Test
  public void testTransferWithOffset() throws IOException {
    try (InputStream inputStream = new FileInputStream(INPUT_FILE);
         OutputStream outputStream = new FileOutputStream(OUTPUT_FILE)) {

      TransferObject transferObject = new TransferObject(inputStream, outputStream);

      int bytesTransferred = transferObject.transfer(22, 10);

      assertEquals(22, bytesTransferred);

      try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
        String outputContent = reader.readLine();
        assertEquals("test input stream with", outputContent);
      }

      transferObject.close();
    }
  }

  @Test
  public void testNegativeOffset() {
    try (InputStream inputStream = new FileInputStream(INPUT_FILE);
         OutputStream outputStream = new FileOutputStream(OUTPUT_FILE)) {

      TransferObject transferObject = new TransferObject(inputStream, outputStream);

      assertThrows(IOException.class, () -> transferObject.transfer(20, -5));

      transferObject.close();
    } catch (IOException e) {
      fail("Unexpected IOException: " + e.getMessage());
    }
  }

  @Test
  public void testTransferWithAppendMode() throws IOException {
    try (InputStream inputStream = new FileInputStream(INPUT_FILE);
         OutputStream outputStream = new FileOutputStream(OUTPUT_FILE, true)) {

      TransferObject transferObject = new TransferObject(inputStream, outputStream);

      transferObject.transfer(20, 0);
      transferObject.close();

      try (OutputStream outputStreamAppend = new FileOutputStream(OUTPUT_FILE, true);
           InputStream inputStreamAppend = new FileInputStream(INPUT_FILE)) {

        transferObject = new TransferObject(inputStreamAppend, outputStreamAppend);
        transferObject.transfer(20, 0);
        transferObject.close();
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
        String outputContent = reader.readLine();
        assertTrue(outputContent.startsWith("This is a test"));
      }
    }
  }
}
