package com.onto.javacourse.inputoutput.reversetextfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides functionality for reversing the content of a text file.
 * It reads the file line by line, reverses the order of the lines,
 * and writes the reversed content back to the file.
 */
public class ReverseTextFile {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReverseTextFile.class);

  /**
   * Reverses the lines of a text file.
   * The method reads the content of the specified file, reverses the order of its lines,
   * and writes the reversed content back into the same file.
   *
   * @param inputFile the path of the file to be reversed
   * @throws IOException if an I/O error occurs while reading or writing to the file
   */
  public static void reversingFile(String inputFile) throws IOException {
    StringBuilder buffer = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        buffer.insert(0, line + System.lineSeparator());
      }
    } catch (IOException e) {
      LOGGER.error("Error reading file: {}", inputFile, e);
      throw new IOException("Error reading file: " + inputFile, e);
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
      writer.write(buffer.toString());
    } catch (IOException e) {
      LOGGER.error("Error writing to file: {}", inputFile, e);
      throw new IOException("Error writing to file: " + inputFile, e);
    }
  }
}
