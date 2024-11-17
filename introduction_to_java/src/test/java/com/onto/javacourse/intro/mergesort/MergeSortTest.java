package com.onto.javacourse.intro.mergesort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testMergeSortWithUnsortedArray() {
        int[] array = {5, 2, 4, 6, 1, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithReverseSortedArray() {
        int[] array = {6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithAllEqualElements() {
        int[] array = {2, 2, 2, 2, 2};
        int[] expected = {2, 2, 2, 2, 2};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithSingleElementArray() {
        int[] array = {1};
        int[] expected = {1};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithEmptyArray() {
        int[] array = {};
        int[] expected = {};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSortWithLargeArray() {
        int[] array = new int[1000];
        int[] expected = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = 1000 - i;
            expected[i] = i + 1;
        }
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }
}
