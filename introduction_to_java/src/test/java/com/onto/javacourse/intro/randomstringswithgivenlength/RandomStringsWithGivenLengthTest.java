package com.onto.javacourse.intro.randomstringswithgivenlength;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

class RandomStringsWithGivenLengthTest {
  private static final Pattern VALID_CHAR_PATTERN = Pattern.compile("[0-9A-Za-z]*");

  @Test
  void testGenerateRandomStringLength() {
    int length = 10;
    String randomString = RandomStringsWithGivenLength.generateRandomString(length);
    assertNotNull(randomString);
    assertEquals(length, randomString.length());
  }

  @Test
  void testGenerateRandomStringInvalidLength() {
    String randomString = RandomStringsWithGivenLength.generateRandomString(0);
    assertNull(randomString);
  }

  @Test
  void testGenerateRandomStringValidCharacters() {
    int length = 50;
    String randomString = RandomStringsWithGivenLength.generateRandomString(length);
    assertNotNull(randomString);
    assertEquals(length, randomString.length());
    for (char c : randomString.toCharArray()) {
      assertTrue(VALID_CHAR_PATTERN.matcher(String.valueOf(c)).matches());
    }
  }

  @Test
  void testGenerateRandomStringRandomness() {
    String randomString1 = RandomStringsWithGivenLength.generateRandomString(10);
    String randomString2 = RandomStringsWithGivenLength.generateRandomString(10);
    assertNotNull(randomString1);
    assertNotNull(randomString2);
    assertNotEquals(randomString1, randomString2);
  }
}
