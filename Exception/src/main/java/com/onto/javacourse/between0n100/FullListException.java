package com.onto.javacourse.between0n100;

/** Exception thrown when attempting to add an element to a full list. */
public class FullListException extends RuntimeException {

  /**
   * Constructs a new FullListException with the specified detail message.
   *
   * @param message the detail message explaining the cause of the exception
   */
  public FullListException(String message) {
    super(message);
  }

  /**
   * Constructs a new FullListException with the specified detail message and cause.
   *
   * @param message the detail message explaining the cause of the exception
   * @param cause the cause of the exception (a throwable that caused this exception to be thrown)
   */
  public FullListException(String message, Throwable cause) {
    super(message, cause);
  }
}
