package com.onto.javacourse.collections.exceptionmanager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages predefined exception messages and generates a combined message string.
 */
public class ExceptionsMessageManager {

  /**
   * Map of predefined exception codes and their corresponding messages.
   */
  private static final Map<String, String> predefinedMessages = new HashMap<>();

  /**
   * Stores the combined exception message.
   */
  private StringBuilder generatedMessage = new StringBuilder();

  /**
   * Delimiter used to separate messages.
   */
  private static final String DELIMITER = " | ";

  // Static block to initialize predefined messages
  static {
    predefinedMessages.put("PIN_ERROR", "Wrong PIN");
    predefinedMessages.put("CARD_ERROR", "Invalid debit card number");
    predefinedMessages.put("ZIP_ERROR", "Invalid zip code");
  }

  /**
   * Adds a message directly if it exists in the predefined values.
   *
   * @param message the message to add
   * @throws IllegalArgumentException if the message is not in the predefined values
   */
  public void addExceptionMessage(String message) {
    if (predefinedMessages.containsValue(message)) {
      if (generatedMessage.length() > 0) {
        generatedMessage.append(DELIMITER);
      }
      generatedMessage.append(message);
    } else {
      throw new IllegalArgumentException("Message not found in predefined messages.");
    }
  }

  /**
   * Adds a message using its predefined code.
   *
   * @param messageCode the code of the message to add
   * @throws IllegalArgumentException if the code is not in the predefined keys
   */
  public void addExceptionMessageUsingCode(String messageCode) {
    String message = predefinedMessages.get(messageCode);
    if (message != null) {
      if (generatedMessage.length() > 0) {
        generatedMessage.append(DELIMITER);
      }
      generatedMessage.append(message);
    } else {
      throw new IllegalArgumentException("Message code not found.");
    }
  }

  /**
   * Returns the full combined exception message.
   *
   * @return the combined message string
   */
  public String getMessage() {
    return generatedMessage.toString();
  }

  /**
   * Splits a combined message string into individual messages.
   *
   * @param messagesCombination the combined message string
   * @return a collection of individual messages
   */
  public static Collection<String> getMessages(String messagesCombination) {
    return Arrays.asList(messagesCombination.split("\\s\\|\\s"));
  }
}
