package com.onto.javacourse.calculator;

/**
 * Command to perform exponentiation operation (base raised to the power of exponent).
 */
public class PowerCommand implements Command {

  private Calculator calculator;
  private double base;
  private int exponent;

  /**
   * Constructs a PowerCommand with the specified calculator, base, and exponent.
   *
   * @param calculator the calculator to perform the operation
   * @param base the base number
   * @param exponent the exponent to raise the base to
   */
  public PowerCommand(Calculator calculator, double base, int exponent) {
    this.calculator = calculator;
    this.base = base;
    this.exponent = exponent;
  }

  /**
   * Executes the exponentiation operation.
   *
   * @return the result of base raised to the power of exponent
   */
  @Override
  public double execute() {
    return calculator.power(base, exponent);
  }
}
