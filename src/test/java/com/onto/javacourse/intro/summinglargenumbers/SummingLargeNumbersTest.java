package com.onto.javacourse.intro.summinglargenumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummingLargeNumbersTest {

    @Test
    void testBasicNumbers() {
        String input = "50 50";
        String expected = "100";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testNumbersWithLeadingZeros() {
        String input = "00050 00050";
        String expected = "100";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testOneNumberWithLeadingZeros() {
        String input = "100 005";
        String expected = "105";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testDifferentLengthsOfOutput() {
        String input = "500 500";
        String expected = "1000";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testNumbersOfDifferentLengths() {
        String input = "123 1111";
        String expected = "1234";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testInvalidInput() {
        String input = "123 abc";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertNull(actual);
    }

    @Test
    void testMoreThanTwoNumbersInvalidInput() {
        String input = "123 456 789";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertNull(actual);
    }

    @Test
    void testNumberWithAllLeadingZeros() {
        String input = "00000001 00000000";
        String expected = "1";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyInputInvalid() {
        String input = "";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertNull(actual);
    }

    @Test
    void testArrayWithLengthOne() {
        String input = "1234";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertNull(actual);
    }

    @Test
    void testLargeNumbers() {
        String input = "5000000000 5000000000";
        String expected = "10000000000";
        String actual = SummingLargeNumbers.summingLargeNumbers(input);
        assertEquals(expected, actual);
    }
}
