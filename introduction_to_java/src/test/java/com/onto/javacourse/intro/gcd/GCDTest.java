package com.onto.javacourse.intro.gcd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDTest {
  /** Test the gcm method with two positive integers */
  @Test
  void theGcdOf12n8Is4() {
    int actual = Gcd.gcd(12, 8);
    int expected = 4;
    assertEquals(expected, actual);
  }

  /** Test the gcm method whether there is importance of the positions of the inputs */
  @Test
  void theGcdOf8n12Is4() {
    int actual = Gcd.gcd(8, 12);
    int expected = 4;
    assertEquals(expected, actual);
  }

  /** Test the gcm method with two identical integers */
  @Test
  void theGcdOf15n15is15() {
    int actual = Gcd.gcd(15, 15);
    int expected = 15;
    assertEquals(expected, actual);
  }

  /** Test the gcm method with one integer = 0 */
  @Test
  void theGcdOf15n0is15() {
    int actual = Gcd.gcd(15, 0);
    int expected = 15;
    assertEquals(expected, actual);
  }

  /** Test the gcm method with one positive integer and one negative integer */
  @Test
  void theGcdOfNegative2n8IsNegative2() {
    int actual = Gcd.gcd(-2, 8);
    int expected = -2;
    assertEquals(expected, actual);
  }

  /** Test the gcm method with two negative integers */
  @Test
  void theGcdOfNegative2nNegative8IsNegative2() {
    int actual = Gcd.gcd(-2, -8);
    int expected = -2;
    assertEquals(expected, actual);
  }
}
