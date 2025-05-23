package com.onto.javacourse.inputoutput.consolereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A utility class for reading various types of input from the console.
 */
public class ConsoleReader {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleReader.class);
  private static BufferedReader reader = null;

  /**
   * Initializes the ConsoleReader with the specified input stream.
   *
   * @param in the input stream to read from
   */
  public ConsoleReader(InputStream in) {
    this.reader = new BufferedReader(new InputStreamReader(in));
  }

  /**
   * Reads a line of text input from the user.
   *
   * @return the input string
   */
  public static String readString() {
    System.out.print("Enter a string: ");
    try {
      return reader.readLine();
    } catch (IOException e) {
      LOGGER.error("Error reading string. Try again.", e);
      return readString();
    }
  }

  /**
   * Reads an integer value from the user.
   *
   * @return the input integer
   */
  public static int readInt() {
    System.out.print("Enter a number: ");
    try {
      return Integer.parseInt(reader.readLine());
    } catch (IOException | NumberFormatException e) {
      LOGGER.error("Error reading number. Try again.", e);
      return readInt();
    }
  }

  /**
   * Reads a single character from the user.
   *
   * @return the input character
   */
  public static Character readChar() {
    System.out.print("Enter a character: ");
    try {
      String line = reader.readLine();
      if (line != null && line.length() == 1) {
        return line.charAt(0);
      } else {
        LOGGER.info("Invalid input. Please enter a single character.");
        return readChar();
      }
    } catch (IOException e) {
      LOGGER.error("Error reading char. Try again.", e);
      return readChar();
    }
  }

  /**
   * Reads a floating-point number from the user.
   *
   * @return the input float value
   */
  public static float readFloat() {
    System.out.print("Enter a float number: ");
    try {
      return Float.parseFloat(reader.readLine());
    } catch (IOException | NumberFormatException e) {
      LOGGER.error("Error reading float. Try again.", e);
      return readFloat();
    }
  }
}
