package com.onto.javacourse.collections.exceptionmanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class ExceptionsMessageManagerTest {

  private ExceptionsMessageManager manager;

  @BeforeEach
  void setUp() {
    manager = new ExceptionsMessageManager();
  }

  @Test
  void getMessages_splitsCorrectly() {
    String combined = "Wrong PIN | Invalid debit card number | Invalid zip code";
    Collection<String> messages = ExceptionsMessageManager.getMessages(combined);

    assertEquals(3, messages.size());
    assertTrue(messages.contains("Wrong PIN"));
    assertTrue(messages.contains("Invalid debit card number"));
    assertTrue(messages.contains("Invalid zip code"));
  }

  @Test
  void addExceptionMessage_validMessage_addsMessage() {
    manager.addExceptionMessage("Wrong PIN");
    assertEquals("Wrong PIN", manager.getMessage());
  }

  @Test
  void addExceptionMessage_invalidMessage_throwsException() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> manager.addExceptionMessage("Unknown message"));
    assertEquals("Message not found in predefined messages.", ex.getMessage());
  }

  @Test
  void addExceptionMessageUsingCode_validCode_addsMessage() {
    manager.addExceptionMessageUsingCode("CARD_ERROR");
    assertEquals("Invalid debit card number", manager.getMessage());
  }

  @Test
  void addExceptionMessageUsingCode_invalidCode_throwsException() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> manager.addExceptionMessageUsingCode("UNKNOWN_CODE"));
    assertEquals("Message code not found.", ex.getMessage());
  }

  @Test
  void addMultipleMessages_checkDelimiter() {
    manager.addExceptionMessage("Wrong PIN");
    manager.addExceptionMessageUsingCode("CARD_ERROR");
    manager.addExceptionMessageUsingCode("ZIP_ERROR");

    String expected = "Wrong PIN | Invalid debit card number | Invalid zip code";
    assertEquals(expected, manager.getMessage());
  }

  @Test
  void getMessages_emptyString_returnsOneEmptyElement() {
    Collection<String> messages = ExceptionsMessageManager.getMessages("");
    assertEquals(1, messages.size());
    assertEquals("", messages.iterator().next());
  }
}
