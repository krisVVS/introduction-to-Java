package com.onto.javacourse.exceptions;

import java.util.Scanner;

public class Reader {
  public static int ReadNumber() throws NumberOutOtRangeException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    String input = scanner.nextLine();
    try {
      int number = Integer.parseInt(input);
      if (number < 0 || number > 100) {
        throw new NumberOutOtRangeException("Number must be between 0 and 100");
      }
      return number;
    } catch (NumberFormatException e) {
      throw new NumberFormatException("Not an integer");
    }
  }

  public static void main(String[] args) {
    try {
      int number = ReadNumber();
      System.out.println("You entered: " + number);
    } catch (NumberOutOtRangeException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
