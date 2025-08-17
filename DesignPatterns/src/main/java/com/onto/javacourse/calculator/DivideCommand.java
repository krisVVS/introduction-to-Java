package com.onto.javacourse.calculator;

/**
 * Command to perform division operation.
 */
public class DivideCommand implements Command {

  private Calculator calculator;
  private double operand1;
  private double operand2;

  /**
   * Constructs a DivideCommand with the specified calculator and operands.
   *
   * @param calculator the calculator to perform the operation
   * @param operand1 the first operand
   * @param operand2 the second operand
   */
  public DivideCommand(Calculator calculator, double operand1, double operand2) {
    this.calculator = calculator;
    this.operand1 = operand1;
    this.operand2 = operand2;
  }

  /**
   * Executes the division operation.
   *
   * @return the result of the division
   */
  @Override
  public double execute() {
    return calculator.divide(operand1, operand2);
  }
}
