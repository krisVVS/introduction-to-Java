package com.onto.javacourse.intro.findingArraysMedian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FindingArraysMedianTest {
    FindingArraysMedian  findingArraysMedian = new FindingArraysMedian ();

    @Test
     void testFindMedianPosition_EmptyArray() {
        int[] array = {};
        int result = findingArraysMedian.median(array);
        assertEquals(-1, result);
    }

    @Test
     void testFindMedianPosition_SingleElementArray() {
        int[] array = {42};
        int result = findingArraysMedian.median(array);
        assertEquals(1, result);
    }

    @Test
     void testFindMedianPosition_TwoElementArray() {
        int[] array = {10, 20};
        int result =  findingArraysMedian.median(array);
        assertEquals(-1, result);
    }

    @Test
     void testFindMedianPosition_ThreeElementArray() {
        int[] array = {10, 1, 20};
        int result =  findingArraysMedian.median(array);
        assertEquals(2, result);
    }

    @Test
     void findingArraysMedian_basicTest2() {
        int [] array = {4,5,99,-1,5,6};
        int actual = findingArraysMedian.median(array);
        int expected = 3;
        assertEquals(expected, actual);

    }

    @Test
     void findingArraysMedianTest_basicTest1() {
        int [] array = {1,2,3,4,5};
        int actual = findingArraysMedian.median(array);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
     void testFindMedianPosition_WithDuplicates() {
        int[] array = {1, 2, 2, 3, 3, 4};
        int result = findingArraysMedian.median(array);
        assertEquals(4, result);
    }

    @Test
     void testFindMedianPosition_Start() {
        int[] array = {99, 2, 2, 3, 3, 4};
        int result = findingArraysMedian.median(array);
        assertEquals(2, result);
    }

    @Test
     void testFindMedianPosition_End() {
        int[] array = {4, 2, 2, 3, 3, 99};
        int result = findingArraysMedian.median(array);
        assertEquals(5, result);
    }
}