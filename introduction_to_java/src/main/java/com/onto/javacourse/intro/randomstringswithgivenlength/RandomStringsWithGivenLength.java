package com.onto.javacourse.intro.randomstringswithgivenlength;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for generating random strings of a specified length. The strings are composed of
 * alphanumeric characters from the ASCII range 48-122, specifically digits ('0'-'9'), uppercase
 * letters ('A'-'Z'), and lowercase letters ('a'-'z').
 */
public class RandomStringsWithGivenLength {
  private static final Random RAND = new Random();
  private static final int MIN = 48;
  private static final int MAX = 122;

  private static final Logger log = LoggerFactory.getLogger(RandomStringsWithGivenLength.class);

  /**
   * Generates a random string of the specified length. The string will consist of alphanumeric
   * characters from the ASCII range 48 to 122.
   *
   * @param stringLength the length of the string to generate. Must be greater than 0.
   * @return a random string of the specified length, or null if the length is less than 1.
   */
  public static String generateRandomString(int stringLength) {
    if (stringLength < 1) {
      log.error("The specified length must be greater than 0.");
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < stringLength; i++) {
      result.append((char) generateRandomNumber());
    }

    String randomString = result.toString();
    log.info("Generated random string: {}", randomString);
    return randomString;
  }

  /**
   * Generates a random number within the ASCII range 48 to 122, excluding non-alphanumeric
   * characters.
   *
   * @return a random number corresponding to an alphanumeric ASCII character.
   */
  private static int generateRandomNumber() {
    int randomNumber = RAND.nextInt(62);
    if (randomNumber < 10) {
      return 48 + randomNumber;
    } else if (randomNumber < 36) {
      return 65 + (randomNumber - 10);
    } else {
      return 97 + (randomNumber - 36);
    }
  }
}
