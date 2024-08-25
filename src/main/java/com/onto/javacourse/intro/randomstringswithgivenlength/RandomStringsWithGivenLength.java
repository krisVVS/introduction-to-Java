package com.onto.javacourse.intro.randomstringswithgivenlength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

/**
 * A utility class for generating random strings with a given length.
 * The characters in the string are limited to the ASCII range 48-122,
 * excluding non-alphanumeric characters like certain symbols.
 */
public class RandomStringsWithGivenLength {
    private static final Random rand = new Random();
    private static final int MIN = 48; // ASCII code for '0'
    private static final int MAX = 122; // ASCII code for 'z'

    private static final Logger log = LoggerFactory.getLogger(RandomStringsWithGivenLength.class);

    /**
     * Generates a random string of the specified length. The string will contain
     * characters from the ASCII range 48 to 122, excluding non-alphanumeric characters.
     *
     * @param stringLength The length of the string to generate. Must be greater than 0.
     * @return A random string of the specified length, or null if the length is less than 1.
     */
    public static String generateRandomString(int stringLength) {
        if (stringLength < 1) {
            log.error("The given length of the string cannot be less than 1");
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringLength; i++) {
            result.append((char) generateRandomNumber());
        }

        String randomString = result.toString();
        log.info("The random string is {}", randomString);
        return randomString;
    }

    /**
     * Generates a random number in the ASCII range 48 to 122, excluding values
     * that represent non-alphanumeric characters.
     *
     * @return A random number that corresponds to an alphanumeric ASCII character.
     */
    private static int generateRandomNumber() {
        int randomNumber;

        do {
            randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        } while ((randomNumber > 57 && randomNumber < 65) || (randomNumber > 90 && randomNumber < 97));

        return randomNumber;
    }
}
