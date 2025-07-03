package com.onto.javacourse.calculator;

/**
 * Command to perform addition operation.
 */
public class AddCommand implements Command {

  private Calculator calculator;
  private double operand1;
  private double operand2;

  /**
   * Constructs an AddCommand with the specified calculator and operands.
   *
   * @param calculator the calculator to perform the operation
   * @param operand1 the first operand
   * @param operand2 the second operand
   */
  public AddCommand(Calculator calculator, double operand1, double operand2) {
    this.calculator = calculator;
    this.operand1 = operand1;
    this.operand2 = operand2;
  }

  /**
   * Executes the addition operation.
   *
   * @return the result of the addition
   */
  @Override
  public double execute() {
    return calculator.add(operand1, operand2);
  }
}
