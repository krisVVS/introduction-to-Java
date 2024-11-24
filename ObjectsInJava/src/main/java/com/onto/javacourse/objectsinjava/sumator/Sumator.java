package com.onto.javacourse.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The {@code Sumator} class provides methods to sum various types of numbers. It supports summing
 * integers, floating-point numbers, strings that represent numbers, and objects of types {@link
 * BigInteger} and {@link BigDecimal}.
 */
public class Sumator {

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
   * @param firstNum the first string representing a number
   * @param secondNum the second string representing a number
   * @return the sum of the parsed numbers
   * @throws NumberFormatException if either string cannot be parsed as a number
   */
  public double sum(String firstNum, String secondNum) throws NumberFormatException {
    double num1 = Double.parseDouble(firstNum);
    double num2 = Double.parseDouble(secondNum);
    return num1 + num2;
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
