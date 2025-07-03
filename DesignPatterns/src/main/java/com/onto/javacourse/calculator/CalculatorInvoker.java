package com.onto.javacourse.calculator;

/**
 * Invoker for executing commands in the calculator.
 */
public class CalculatorInvoker {

  private Command command;

  /**
   * Sets the command to be executed.
   *
   * @param command the command to set
   */
  public void setCommand(Command command) {
    this.command = command;
  }

  /**
   * Invokes the execution of the command.
   *
   * @return the result of the executed command
   */
  public double invoke() {
    return command.execute();
  }
}
