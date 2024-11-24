package com.onto.javacourse.intro.arrayprocessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProcessingTest {

  private final ArrayProcessing arrayProcessing = new ArrayProcessing();

  @Test
  void testGetMinElementIndexWithEmptyArray() {
    int[] array = {};
    int index = arrayProcessing.getMinElementIndex(array);
    assertEquals(-1, index);
  }

  @Test
  void testGetMinElementIndex() {
    int[] array = {3, 1, 4, 1, 5, 9};
    int index = arrayProcessing.getMinElementIndex(array);
    assertEquals(1, index);
  }

  @Test
  void testSum() {
    int[] array = {1, 2, 3, 4};
    int result = arrayProcessing.sum(array);
    assertEquals(10, result);
  }

  @Test
  void testPrint() {
    int[] array = {1, 2, 3, 4};
    String result = arrayProcessing.print(array);
    assertEquals("[1, 2, 3, 4]", result);
  }

  @Test
  void testContiguousArrayLargestSum() {
    int[] array = {1, -2, 3, 4, -1, 2, 1, -5, 4};
    int[] result = arrayProcessing.contiguousArrayLargestSum(array);
    assertArrayEquals(new int[] {3, 4, -1, 2, 1}, result);
  }

  @Test
  void testContiguousArrayLargestSumSingleElement() {
    int[] array = {3};
    int[] result = arrayProcessing.contiguousArrayLargestSum(array);
    assertArrayEquals(new int[] {3}, result);
  }

  @Test
  void testContiguousArrayLargestSumAllNegative() {
    int[] array = {-2, -3, -1, -4};
    int[] result = arrayProcessing.contiguousArrayLargestSum(array);
    assertArrayEquals(new int[] {-1}, result);
  }
}
