package com.onto.javacourse.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code Sumator} class provides methods to sum various types of numbers. It supports summing
 * integers, floating-point numbers, strings that represent numbers, and objects of types {@link
 * BigInteger} and {@link BigDecimal}.
 */
public class Sumator {
  private static final Logger LOGGER = LoggerFactory.getLogger(Sumator.class);

  /**
   * Sums two integers.
   *
   * @param firstNum the first integer
   * @param secondNum the second integer
   * @return the sum of the two integers
   */
  public int sum(int firstNum, int secondNum) {
    return firstNum + secondNum;
  }

  /**
   * Sums two floating-point numbers.
   *
   * @param firstNum the first floating-point number
   * @param secondNum the second floating-point number
   * @return the sum of the two floating-point numbers
   */
  public double sum(double firstNum, double secondNum) {
    return firstNum + secondNum;
  }

  /**
   * Sums two strings that represent numbers. The strings are parsed as doubles before summing.
   *
   * <p>Parses the input strings to double values and returns their sum. If the inputs are invalid
   * (non-numeric or null), logs an error and returns {@code 0.0}.
   *
   * @param firstNum the first number as a string
   * @param secondNum the second number as a string
   * @return the sum of the two numbers, or {@code 0.0} if an error occurs
   */
  public double sum(String firstNum, String secondNum) {
    try {
      double number1 = Double.parseDouble(firstNum);
      double number2 = Double.parseDouble(secondNum);
      return number1 + number2;
    } catch (NumberFormatException e) {
      LOGGER.error("Invalid number format:");
      throw new NumberFormatException();
    } catch (NullPointerException e) {
      LOGGER.error("Null input provided for one or both parameters.");
      throw new NullPointerException();
    }
  }

  /**
   * Sums two {@link BigInteger} objects.
   *
   * @param firstNum the first {@code BigInteger}
   * @param secondNum the second {@code BigInteger}
   * @return the sum of the two {@code BigInteger} objects
   */
  public BigInteger sum(BigInteger firstNum, BigInteger secondNum) {
    return firstNum.add(secondNum);
  }

  /**
   * Sums two {@link BigDecimal} objects.
   *
   * @param firstNum the first {@code BigDecimal}
   * @param secondNum the second {@code BigDecimal}
   * @return the sum of the two {@code BigDecimal} objects
   */
  public BigDecimal sum(BigDecimal firstNum, BigDecimal secondNum) {
    return firstNum.add(secondNum);
  }
}