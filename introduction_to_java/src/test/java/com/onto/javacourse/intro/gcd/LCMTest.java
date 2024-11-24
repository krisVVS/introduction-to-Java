package com.onto.javacourse.intro.gcd;

import com.onto.javacourse.intro.gcd.Gcd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCMTest {
  /** Tests the lcm method with positive integers. */
  @Test
  void theLcmOf12n8Is24() {
    int actual = Gcd.lcm(12, 8);
    int expected = 24;
    assertEquals(expected, actual);
  }

  /** Tests the lcm method with two identical integers. */
  @Test
  void theLcmOf15n15is15() {
    int actual = Gcd.lcm(15, 15);
    int expected = 15;
    assertEquals(expected, actual);
  }

  /** Tests the lcm method with one positive integer and one 0. */
  @Test
  void theLcmOf15n0is0() {
    int actual = Gcd.lcm(0, 0);
    int expected = 0;
    assertEquals(expected, actual);
  }

  /** Tests the lcm method with one positive integer and one negative integer. */
  @Test
  void theLcmOfNegative2n8Is8() {
    int actual = Gcd.lcm(-2, 8);
    int expected = 8;
    assertEquals(expected, actual);
  }

  /** Tests the lcm method with two positive integers. */
  @Test
  void theLcmOfNegative2nNegative8IsNegative8() {
    int actual = Gcd.lcm(-2, -8);
    int expected = -8;
    assertEquals(expected, actual);
  }
}
