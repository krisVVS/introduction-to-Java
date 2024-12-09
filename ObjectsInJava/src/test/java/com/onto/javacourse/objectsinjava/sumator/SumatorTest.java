package com.onto.javacourse.objectsinjava.sumator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.BigInteger;

class SumatorTest {

  Sumator sumator = new Sumator();

  @Test
  void testSumIntegers() {
    int result = sumator.sum(10, 20);
    assertEquals(30, result);
  }

  @Test
  void testSumDoubles() {
    double result = sumator.sum(10.5, 20.3);
    assertEquals(30.8, result, 0.0001);
  }

  @Test
  void testSumStrings() {
    double result = sumator.sum("10.5", "20.3");
    assertEquals(30.8, result, 0.0001);
  }

  @Test
  void testNullInputs() {
    Exception exception1 =
        assertThrows(IllegalArgumentException.class, () -> sumator.sum(null, "5.5"));
    assertEquals("Input values cannot be null.", exception1.getMessage());

    Exception exception2 =
        assertThrows(IllegalArgumentException.class, () -> sumator.sum("5.5", null));
    assertEquals("Input values cannot be null.", exception2.getMessage());
  }

  @Test
  void testInvalidNumericInputs() {
    Exception exception1 =
        assertThrows(IllegalArgumentException.class, () -> sumator.sum("abc", "5.5"));
    assertEquals("Both inputs must be numeric values.", exception1.getMessage());

    Exception exception2 =
        assertThrows(IllegalArgumentException.class, () -> sumator.sum("5.5", "xyz"));
    assertEquals("Both inputs must be numeric values.", exception2.getMessage());

    Exception exception3 =
        assertThrows(IllegalArgumentException.class, () -> sumator.sum("123abc", "456def"));
    assertEquals("Both inputs must be numeric values.", exception3.getMessage());
  }

  @Test
  void testSumBigIntegers() {
    BigInteger result =
        sumator.sum(new BigInteger("1000000000000000000"), new BigInteger("2000000000000000000"));
    assertEquals(new BigInteger("3000000000000000000"), result);
  }

  @Test
  void testSumBigDecimals() {
    BigDecimal result = sumator.sum(new BigDecimal("10.5"), new BigDecimal("20.3"));
    assertEquals(new BigDecimal("30.8"), result);
  }
}