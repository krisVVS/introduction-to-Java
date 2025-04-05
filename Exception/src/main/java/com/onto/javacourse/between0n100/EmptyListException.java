package com.onto.javacourse.between0n100;

/**
 * Exception thrown when attempting to remove an element from an empty list.
 */
public class EmptyListException extends RuntimeException {

  /**
   * Constructs a new EmptyListException with the specified detail message.
   *
   * @param message the detail message explaining the cause of the exception
   */
  public EmptyListException(String message) {
    super(message);
  }

  /**
   * Constructs a new EmptyListException with the specified detail message and cause.
   *
   * @param message the detail message explaining the cause of the exception
   * @param cause the cause of the exception (a throwable that caused this exception to be thrown)
   */
  public EmptyListException(String message, Throwable cause) {
    super(message, cause);
  }
}
