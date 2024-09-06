package com.onto.javacourse.objectsinjava.sumator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class SumatorTest {

    Sumator sumator = new Sumator();

    @Test
    public void testSumIntegers() {
        int result = sumator.sum(10, 20);
        assertEquals(30, result);
    }

    @Test
    public void testSumDoubles() {
        double result = sumator.sum(10.5, 20.3);
        assertEquals(30.8, result, 0.0001);
    }

    @Test
    public void testSumStrings() {
        double result = sumator.sum("10.5", "20.3");
        assertEquals(30.8, result, 0.0001);
    }

    @Test
    public void testSumStringsInvalidInput() {
        assertThrows(NumberFormatException.class, () -> {
            sumator.sum("abc", "20.3");
        });
    }

    @Test
    public void testSumBigIntegers() {
        BigInteger result = sumator.sum(new BigInteger("1000000000000000000"), new BigInteger("2000000000000000000"));
        assertEquals(new BigInteger("3000000000000000000"), result);
    }

    @Test
    public void testSumBigDecimals() {
        BigDecimal result = sumator.sum(new BigDecimal("10.5"), new BigDecimal("20.3"));
        assertEquals(new BigDecimal("30.8"), result);
    }
}
