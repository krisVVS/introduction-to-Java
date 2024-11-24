package com.onto.javacourse.intro.findingarraysmedian;

import com.onto.javacourse.intro.arrayprocessing.ArrayProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for finding the median-like position in an array that balances the sums of elements on
 * either side as much as possible.
 */
public class FindingArraysMedian extends ArrayProcessing {

  private static final Logger LOGGER = LoggerFactory.getLogger(FindingArraysMedian.class);

  /**
   * Finds the 1-based index in the array that balances the sums of elements on either side of the
   * index as much as possible.
   *
   * <p>The position is 1-based, meaning that the first position in the array is 1.
   *
   * <p>If the array has only one element, the method returns 1 as there is no meaningful median
   * position in a single-element array.
   *
   * <p>If the array has fewer than three elements, the method logs a warning and returns -1 because
   * a median cannot be determined in such cases.
   *
   * @param array the input array of integers. The array must contain at least 3 elements for a
   *     valid median calculation.
   * @return the 1-based index of the position that results in the most balanced partition. Returns
   *     -1 if the array length is less than 3.
   * @throws IllegalArgumentException if the input array is {@code null}.
   */
  public int findMedian(final int[] array) {
    if (array == null) {
      LOGGER.error("The input array is null.");
      throw new IllegalArgumentException("Input array cannot be null.");
    }

    int n = array.length;

    if (n == 1) {
      return 1;
    }

    if (n <= 2) {
      LOGGER.warn("Cannot determine the median of an array with less than 3 elements.");
      return -1;
    }

    int totalSum = sum(array);
    int leftSum = array[0];
    int minDiff = Integer.MAX_VALUE;
    int resultIndex = -1;

    for (int i = 1; i < n - 1; i++) {
      int rightSum = totalSum - leftSum - array[i];
      int diff = Math.abs(leftSum - rightSum);

      if (diff < minDiff) {
        minDiff = diff;
        resultIndex = i + 1;
      }

      leftSum += array[i];
    }

    return resultIndex;
  }
}
