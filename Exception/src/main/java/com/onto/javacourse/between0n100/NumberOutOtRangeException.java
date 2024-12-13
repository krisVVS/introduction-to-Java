package com.onto.javacourse.between0n100;

/** Exception thrown when a number is outside the valid range. */
public class NumberOutOtRangeException extends RuntimeException {
  /**
   * Constructs a new NumberOutOfRangeException with the specified detail message.
   *
   * @param message the detail message explaining the cause of the exception
   */
  public NumberOutOtRangeException(String message) {
    super(message);
  }
}
