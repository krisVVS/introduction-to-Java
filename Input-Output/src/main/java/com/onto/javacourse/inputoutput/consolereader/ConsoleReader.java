package com.onto.javacourse.inputoutput.consolereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleReader {
  private static BufferedReader reader = null;

  public ConsoleReader(InputStream in) {
    this.reader = new BufferedReader(new InputStreamReader(in));
  }

  public static String readString() {
    System.out.print("Enter a string: ");
    try {
      return reader.readLine();
    } catch (IOException e) {
      System.out.println("Error reading string. Try again.");
      return readString();
    }
  }

  public static int readInt() {
    System.out.print("Enter a number: ");
    try {
      return Integer.parseInt(reader.readLine());
    } catch (IOException | NumberFormatException e) {
      System.out.println("Invalid input. Please enter a valid integer.");
      return readInt();
    }
  }

  public static Character readChar() {
    System.out.print("Enter a character: ");
    try {
      String line = reader.readLine();
      if (line != null && line.length() == 1) {
        return line.charAt(0);
      } else {
        System.out.println("Invalid input. Please enter a single character.");
        return readChar();
      }
    } catch (IOException e) {
      System.out.println("Invalid input. Please enter a single character.");
      return readChar();
    }
  }

  public static float readFloat() {
    System.out.print("Enter a float number: ");
    try {
      return Float.parseFloat(reader.readLine());
    } catch (IOException | NumberFormatException e) {
      System.out.println("Invalid input. Please enter a valid float.");
      return readFloat();
    }
  }
}