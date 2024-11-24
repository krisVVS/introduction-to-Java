package com.onto.javacourse.intro.arrayprocessing;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Utility class for processing arrays. */
public class ArrayProcessing {

  private static final Logger LOGGER = LoggerFactory.getLogger(ArrayProcessing.class);

  /**
   * Finds the index of the minimum element in the array.
   *
   * @param array the array to process
   * @return the index of the minimum element, or -1 if the array is empty
   * @throws IllegalArgumentException if the array is null
   */
  public static int getMinElementIndex(final int[] array) {
    if (array == null) {
      LOGGER.warn("Received a null array in method getMinElementIndex.");
      throw new IllegalArgumentException("Array cannot be null.");
    }
    if (array.length == 0) {
      LOGGER.info("The array is empty.");
      return -1;
    }

    int min = array[0];
    int index = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
        index = i;
      }
    }
    return index;
  }

  /**
   * Calculates the sum of all elements in the array.
   *
   * @param array the array to process
   * @return the sum of the array elements
   * @throws IllegalArgumentException if the array is null
   */
  public static int sum(final int[] array) {
    if (array == null) {
      LOGGER.warn("Received a null array in method sum.");
      throw new IllegalArgumentException("Array cannot be null.");
    }

    int sum = 0;
    for (int element : array) {
      sum += element;
    }
    return sum;
  }

  /**
   * Returns a string representation of the array.
   *
   * @param array the array to process
   * @return the string representation of the array
   * @throws IllegalArgumentException if the array is null
   */
  public static String print(final int[] array) {
    if (array == null) {
      LOGGER.warn("Received a null array in method print.");
      throw new IllegalArgumentException("Array cannot be null.");
    }
    return Arrays.toString(array);
  }

  /**
   * Finds the subarray with the largest sum using Kadane's algorithm.
   *
   * @param array the array to process
   * @return the subarray with the largest sum
   * @throws IllegalArgumentException if the array is null
   */
  public static int[] contiguousArrayLargestSum(final int[] array) {
    if (array == null) {
      LOGGER.warn("Received a null array in method contiguousArrayLargestSum.");
      throw new IllegalArgumentException("Array cannot be null.");
    }

    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;
    int start = 0;
    int end = 0;
    int currentStartIndex = 0;

    for (int i = 0; i < array.length; i++) {
      maxEndingHere += array[i];

      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
        start = currentStartIndex;
        end = i;
      }

      if (maxEndingHere < 0) {
        maxEndingHere = 0;
        currentStartIndex = i + 1;
      }
    }

    LOGGER.info("Maximum sum of contiguous subarray: {}", maxSoFar);

    int[] contiguousArray = new int[end - start + 1];
    if (end + 1 - start >= 0) {
      System.arraycopy(array, start, contiguousArray, 0, end + 1 - start);
    }
    return contiguousArray;
  }
}
