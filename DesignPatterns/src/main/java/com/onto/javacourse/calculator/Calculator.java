package com.onto.javacourse.calculator;

/**
 * Calculator class to perform basic arithmetic operations.
 */
public class Calculator {

  /**
   * Adds two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the sum of a and b
   */
  public double add(double a, double b) {
    return a + b;
  }

  /**
   * Subtracts one number from another.
   *
   * @param a the first number
   * @param b the second number
   * @return the result of a - b
   */
  public double subtract(double a, double b) {
    return a - b;
  }

  /**
   * Multiplies two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the product of a and b
   */
  public double multiply(double a, double b) {
    return a * b;
  }

  /**
   * Divides one number by another.
   *
   * @param a the numerator
   * @param b the denominator
   * @return the result of a / b
   * @throws ArithmeticException if b is zero
   */
  public double divide(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Cannot divide by zero");
    }
    return a / b;
  }

  /**
   * Raises a base number to the power of an exponent.
   *
   * @param base the base number
   * @param exponent the exponent
   * @return the result of base raised to the exponent
   */
  public double power(double base, int exponent) {
    return Math.pow(base, exponent);
  }
}
