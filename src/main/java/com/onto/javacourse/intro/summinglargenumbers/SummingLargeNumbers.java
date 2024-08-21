package com.onto.javacourse.intro.summinglargenumbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a method to sum two large numbers represented as strings.
 */
public class SummingLargeNumbers {

    private static final Logger log = LoggerFactory.getLogger(SummingLargeNumbers.class);

    /**
     * Sums two large numbers provided as a single string.
     *
     * @param input a string containing two numbers separated by a space
     * @return the sum of the two numbers as a string, or null if the input is invalid
     */
    public static String summingLargeNumbers(String input) {
        StringBuilder result = new StringBuilder();

        if (checkForLetters(input)) {
            log.error("Wrong input: {}", input);
            return null;
        }

        String[] array = input.split(" ");
        if (array.length != 2) {
            log.error("Wrong input: {}", input);
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
     * Checks if the given string contains any letters.
     *
     * @param str the string to check
     * @return true if the string contains letters, false otherwise
     */
    private static boolean checkForLetters(String str) {
        return str.matches(".*[a-zA-Z].*");
    }

    /**
     * Removes leading zeros from a string representation of a number.
     *
     * @param str the string to process
     * @return the string with leading zeros removed
     */
    private static String removeLeadingZeros(String str) {
        return str.replaceFirst("^0+(?!$)", "");
    }

    /**
     * Ensures the first number in the array is longer or equal in length to the second number.
     *
     * @param array an array containing two numbers as strings
     */
    private static void ensureFirstNumberIsLonger(String[] array) {
        if (array[0].length() < array[1].length()) {
            String temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
    }
}
