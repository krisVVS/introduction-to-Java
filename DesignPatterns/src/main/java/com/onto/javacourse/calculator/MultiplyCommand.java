package com.onto.javacourse.calculator;

/**
 * Command to perform multiplication operation.
 */
public class MultiplyCommand implements Command {

  private Calculator calculator;
  private double operand1;
  private double operand2;

  /**
   * Constructs a MultiplyCommand with the specified calculator and operands.
   *
   * @param calculator the calculator to perform the operation
   * @param operand1 the first operand
   * @param operand2 the second operand
   */
  public MultiplyCommand(Calculator calculator, double operand1, double operand2) {
    this.calculator = calculator;
    this.operand1 = operand1;
    this.operand2 = operand2;
  }

  /**
   * Executes the multiplication operation.
   *
   * @return the result of the multiplication
   */
  @Override
  public double execute() {
    return calculator.multiply(operand1, operand2);
  }
}
