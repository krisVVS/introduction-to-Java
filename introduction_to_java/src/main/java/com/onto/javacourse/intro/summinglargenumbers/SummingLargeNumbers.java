package com.onto.javacourse.intro.summinglargenumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a method to sum two large numbers represented as strings. The algorithm involves
 * reversing them and adding extra 0s until both numbers are the same length. After that, we add
 * every two one-digit numbers together + a carry value, which differs between 1 and 0 depending on
 * whether the sum of the two is greater than or equal to 10.
 */
public class SummingLargeNumbers {
  private static final Logger log = LoggerFactory.getLogger(SummingLargeNumbers.class);

  /**
   * Sums two large numbers provided as two strings.
   *
   * @param num1 the first large number as a string
   * @param num2 the second large number as a string
   * @return the sum of the two numbers as a string, or null if the input is invalid
   */
  public static String summingLargeNumbers(String num1, String num2) {

    if (!isValidInput(num1) || !isValidInput(num2)) {
      log.error("Invalid input: {} and {}", num1, num2);
      return null;
    }

    num1 = removeLeadingZeros(num1);
    num2 = removeLeadingZeros(num2);

    if (num1.length() < num2.length()) {
      String temp = num1;
      num1 = num2;
      num2 = temp;
    }

    StringBuilder num1Builder = new StringBuilder(num1);
    StringBuilder num2Builder = new StringBuilder(num2);

    num1Builder.reverse();
    num2Builder.reverse();

    while (num2Builder.length() < num1Builder.length()) {
      num2Builder.append("0");
    }
    StringBuilder result = new StringBuilder();
    int carry = 0;

    for (int i = 0; i < num1Builder.length(); i++) {
      int digit1 = Character.getNumericValue(num1Builder.charAt(i));
      int digit2 = Character.getNumericValue(num2Builder.charAt(i));
      int sum = digit1 + digit2 + carry;

      result.append(sum % 10);
      carry = sum / 10;
    }

    if (carry > 0) {
      result.append(carry);
    }

    return result.reverse().toString();
  }

  /**
   * Checks if the given string contains only digits.
   *
   * @param str the string to check
   * @return true if the string contains only digits, false otherwise
   */
  private static boolean isValidInput(String str) {
    return str.matches("\\d+");
  }

  /**
   * Removes leading zeros from a string representation of a number.
   *
   * @param str the string to process
   * @return the string with leading zeros removed
   */
  private static String removeLeadingZeros(String str) {
    return str.replaceFirst("^0+(?!$)", "");
  }
}
