package com.onto.javacourse.calculator;

/**
 * Command interface for all calculator operations.
 */
public interface Command {

  /**
   * Executes the command.
   *
   * @return the result of the operation
   */
  double execute();
}
