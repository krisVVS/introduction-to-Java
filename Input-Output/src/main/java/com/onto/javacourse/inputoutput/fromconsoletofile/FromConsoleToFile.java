package com.onto.javacourse.inputoutput.fromconsoletofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that reads text from the console and writes it to a specified file.
 * The user can enter multiple lines of text, and the input process ends when the user
 * types a line containing only a period (".").
 * The file path is passed as an argument to the {@link #writeToFile(String)} method.
 *
 * <p>The class uses {@link BufferedReader} to read console input and {@link BufferedWriter}
 * to write the content to a file. It ensures that the resources are properly closed after use.</p>
 */
public class FromConsoleToFile {

  /**
   * Logger for the class, used for logging errors.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(FromConsoleToFile.class);

  /**
   * Reads input from the console and writes it to a file specified by the given file path/name.
   * The input process continues until the user types a period (".") on a new line.
   *
   * @param filename The name of the file where the input text will be written.
   */
  public void writeToFile(String filename) throws IOException {
    try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename))
    ) {
      String line;

      System.out.println("Enter text to write to file. Type '.' on a new line to stop.");
      while ((line = reader.readLine()) != null && !".".equals(line)) {
        writer.write(line);
        writer.newLine();
      }
      System.out.println("Content has been written to " + filename);
    } catch (IOException e) {
      LOGGER.error("Error during I/O operations: {}", e.getMessage());
      throw new IOException();
    }
  }
}
