package com.onto.javacourse.emailvalidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

  @Test
  void testValidEmail() {
    assertTrue(EmailValidator.validateEmail("valid.email@example.com"));
    assertTrue(EmailValidator.validateEmail("user.name@sub.domainorg"));
    assertTrue(EmailValidator.validateEmail("user-name@domain.com"));
  }

  @Test
  void testInvalidEmail() {
    assertFalse(EmailValidator.validateEmail(null));
    assertFalse(EmailValidator.validateEmail(""));
    assertFalse(EmailValidator.validateEmail("invalid.email@"));
    assertFalse(EmailValidator.validateEmail("@invalid.com"));
    assertFalse(EmailValidator.validateEmail("invalid@.com"));
    assertFalse(EmailValidator.validateEmail("invalid@domain."));
    assertFalse(EmailValidator.validateEmail("invalid@domain..com"));
    assertFalse(EmailValidator.validateEmail("user@domain.123"));
  }

  @Test
  void testEdgeCases() {
    assertTrue(EmailValidator.validateEmail("a@b.co"));
    assertFalse(EmailValidator.validateEmail("1user@domain.com"));
    assertFalse(EmailValidator.validateEmail("user@-domain.com"));
    assertFalse(EmailValidator.validateEmail("user@domain-.com"));
  }
}
