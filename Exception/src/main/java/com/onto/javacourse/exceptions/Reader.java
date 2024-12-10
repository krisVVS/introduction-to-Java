package com.onto.javacourse.exceptions;

import java.util.Scanner;

/**
 * Reads numbers from the console within the range 0-100.
 *
 * <p>Ensures the input is numeric and within range. Throws a {@link NumberOutOtRangeException} for
 * invalid inputs or out-of-range values.
 */
public class Reader {

  /**
   * Reads a number from the console and ensures it is in the 0-100 range.
   *
   * @return the number if it is within the valid range
   * @throws NumberOutOtRangeException if the number is outside the 0-100 range
   * @throws NumberFormatException if the input is not a valid number
   */
  public static int readNumber() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter an integer (0-100): ");
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
}
