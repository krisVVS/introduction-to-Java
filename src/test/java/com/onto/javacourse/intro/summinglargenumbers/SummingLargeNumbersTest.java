package com.onto.javacourse.intro.summinglargenumbers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SummingLargeNumbersTest {

    @Test
    void testBasicNumbers() {
        String num1 = "50";
        String num2 = "50";
        String expected = "100";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testNumbersWithLeadingZeros() {
        String num1 = "00050";
        String num2 = "00050";
        String expected = "100";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testOneNumberWithLeadingZeros() {
        String num1 = "100";
        String num2 = "005";
        String expected = "105";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testDifferentLengthsOfOutput() {
        String num1 = "500";
        String num2 = "500";
        String expected = "1000";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testNumbersOfDifferentLengths() {
        String num1 = "99999";
        String num2 = "1";
        String expected = "100000";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testNumbersOfDifferentLengths2() {
        String num1 = "0";
        String num2 = "100001";
        String expected = "100001";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testInvalidInput() {
        String num1 = "123";
        String num2 = "123!@#$123";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertNull(actual);
    }

    @Test
    void testMoreThanTwoNumbersInvalidInput() {
        String num1 = "123";
        String num2 = "456";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertNotNull(actual);
    }

    @Test
    void testNumberWithAllLeadingZeros() {
        String num1 = "00000001";
        String num2 = "00000000";
        String expected = "1";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyInputInvalid() {
        String num1 = "";
        String num2 = "";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertNull(actual);
    }

    @Test
    void testArrayWithLengthOne() {
        String num1 = "1234";
        String num2 = "";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertNull(actual);
    }

    @Test
    void testLargeNumbers() {
        String num1 = "5000000000";
        String num2 = "5000000000";
        String expected = "10000000000";
        String actual = SummingLargeNumbers.summingLargeNumbers(num1, num2);
        assertEquals(expected, actual);
    }
}
