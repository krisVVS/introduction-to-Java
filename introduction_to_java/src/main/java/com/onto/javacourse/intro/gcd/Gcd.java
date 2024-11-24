package com.onto.javacourse.intro.gcd;

/**
 * Utility class for calculating the Greatest Common Divisor (GCD) and
 * Least Common Multiple (LCM) of integers.
 */
public class Gcd {
  /**
   * Method to calculate the Greatest Common Divisor (GCD) using the Euclidean algorithm.
   *
   * @param n1 the first integer
   * @param n2 the second integer
   * @return the GCD of n1 and n2
   * @since 31.07.2024
   * @author Kristian Vasilev
   */
  public static int gcd(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcd(n2, n1 % n2);
  }

  /**
   * Method to calculate the Least Common Multiple (LCM).
   *
   * @param n1 the first integer
   * @param n2 the second integer
   * @return the LCM of n1 and n2, or 0 if either number is zero (Because there is not an LCM in
   *     that case.)
   * @since 31.07.2024
   * @author Kristian Vasilev
   */
  public static int lcm(int n1, int n2) {
    if (n2 == 0 || n1 == 0) {
      return 0;
    } else {
      return n1 * n2 / gcd(n1, n2);
    }
  }
}
