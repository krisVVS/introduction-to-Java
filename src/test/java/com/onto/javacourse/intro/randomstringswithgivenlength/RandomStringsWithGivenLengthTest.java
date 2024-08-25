package com.onto.javacourse.intro.randomstringswithgivenlength;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RandomStringsWithGivenLengthTest {

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

        for (char c : randomString.toCharArray()) {
            assertTrue((c >= '0' && c <= '9') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z'));
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
