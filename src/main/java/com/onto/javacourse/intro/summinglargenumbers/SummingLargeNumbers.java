package com.onto.javacourse.intro.summinglargenumbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A utility class for summing two large numbers represented as strings.
 */
public class SummingLargeNumbers {
    private static final Logger log = LoggerFactory.getLogger(SummingLargeNumbers.class);

    /**
     * Sums two large numbers represented as strings.
     *
     * @param input A string containing two non-negative integers separated by a space.
     * @return The sum of the two numbers as a string, or {@code null} if the input is invalid.
     */
    public static String summingLargeNumbers(String input) {
        StringBuilder result = new StringBuilder();
        if (checkForLetters(input)) {
            log.error("Invalid input: {}", input);
            return null;
        }

        String[] array = input.split(" ");
        if (array.length != 2) {
            log.error("Invalid input: {}", input);
            return null;
        }

        array[0] = removeLeadingZeros(array[0]);
        array[1] = removeLeadingZeros(array[1]);

        ensureFirstNumberIsLonger(array);

        StringBuilder num1 = new StringBuilder(array[0]);
        StringBuilder num2 = new StringBuilder(array[1]);

        num1.reverse();
        num2.reverse();

        while (num2.length() < num1.length()) {
            num2.append("0");
        }

        int carry = 0;
        for (int i = 0; i < num1.length(); i++) {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int digit2 = Character.getNumericValue(num2.charAt(i));
            int sum = digit1 + digit2 + carry;

            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    /**
     * Checks if the given string contains any alphabetic characters.
     *
     * @param str The string to check.
     * @return {@code true} if the string contains any alphabetic characters; {@code false} otherwise.
     */
    private static boolean checkForLetters(String str) {
        return str.matches(".*[a-zA-Z].*");
    }

    /**
     * Removes leading zeros from a string representation of a number.
     *
     * @param str The string from which leading zeros should be removed.
     * @return The string with leading zeros removed.
     */
    private static String removeLeadingZeros(String str) {
        return str.replaceFirst("^0+(?!$)", "");
    }

    /**
     * Ensures that the first number in the array is longer than or equal to the second number.
     *
     * @param array An array containing two numbers in string form.
     */
    private static void ensureFirstNumberIsLonger(String[] array) {
        if (array[0].length() < array[1].length()) {
            String temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
    }
}
