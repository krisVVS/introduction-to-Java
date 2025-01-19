package com.onto.javacourse.emailvalidator;

import java.util.logging.Logger;

/**
 * A utility class for validating email addresses based on a predefined regular expression.
 */
public class EmailValidator {

  /**
   * Regular expression for validating email addresses.
   * Ensures the email starts with a Latin letter, contains valid characters,
   * and has a valid domain and TLD.
   */
  private static final String emailRegEx =
      "^[a-zA-Z][a-zA-Z0-9._-]*@[a-zA-Z][a-zA-Z0-9]*\\.[a-zA-Z]{2,}$";

  private static final Logger LOGGER = Logger.getLogger(EmailValidator.class.getName());

  /**
   * Validates the given email address against the predefined regular expression.
   *
   * @param email the email address to validate
   * @return true if the email is valid, false otherwise
   */
  public static boolean validateEmail(String email) {
    if (email == null || email.isEmpty()) {
      LOGGER.severe("Email is null or empty");
      return false;
    }
    return email.matches(emailRegEx);
  }

}
