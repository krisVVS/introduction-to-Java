package com.onto.javacourse.intro.mergesort;

/**
 * Utility class for sorting an array using the merge sort algorithm.
 */
public class MergeSort {

  /**
   * Sorts the given array of integers using the merge sort algorithm.
   *
   * @param array the array of integers to be sorted
   * @throws NullPointerException if the array is {@code null}
   */
  public static void mergeSort(int[] array) {
    int length = array.length;
    if (length < 2) {
      return;
    }
    int mid = length / 2;
    int[] leftArray = new int[mid];
    int[] rightArray = new int[length - mid];

    System.arraycopy(array, 0, leftArray, 0, mid);
    System.arraycopy(array, mid, rightArray, 0, length - mid);

    mergeSort(leftArray);
    mergeSort(rightArray);

    merge(leftArray, rightArray, array);
  }

  /**
   * Merges two sorted sub-arrays into a single sorted array.
   *
   * @param leftArray the left sub-array, which is already sorted
   * @param rightArray the right sub-array, which is already sorted
   * @param array the array into which the merged elements will be placed
   * @throws NullPointerException if any of the arrays are {@code null}
   */
  private static void merge(int[] leftArray, int[] rightArray, int[] array) {
    int leftSize = array.length / 2;
    int rightSize = array.length - leftSize;
    int i = 0;
    int l = 0;
    int r = 0;

    while (l < leftSize && r < rightSize) {
      if (leftArray[l] < rightArray[r]) {
        array[i] = leftArray[l];
        i++;
        l++;
      } else {
        array[i] = rightArray[r];
        i++;
        r++;
      }
    }

    while (l < leftSize) {
      array[i] = leftArray[l];
      i++;
      l++;
    }

    while (r < rightSize) {
      array[i] = rightArray[r];
      i++;
      r++;
    }
  }
}
