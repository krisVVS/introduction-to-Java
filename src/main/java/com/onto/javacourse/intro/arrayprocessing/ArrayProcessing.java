package com.onto.javacourse.intro.arrayprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ArrayProcessing {
    private static final Logger log = LoggerFactory.getLogger(ArrayProcessing.class);

    /**
     * Finds the index of the minimum element in the array.
     *
     * @param array the array to process
     * @return the index of the minimum element, or -1 if the array is empty
     * @author Kristian Vasilev
     */
    public int getMinElementIndex(int[] array) {
        if (array.length == 0) {
            log.info("The array is empty");
            return -1;
        } else {
            int min = array[0];
            int index= 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {min=array[i];index=i;}
            }
            return index;
        }
    }

    /**
     * Calculates the sum of all elements in the array.
     *
     * @param array the array to process
     * @return the sum of the array elements
     * @author Kristian Vasilev
     */
    public int sum(int[] array){
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    /**
     * Returns a string representation of the array.
     *
     * @param array the array to process
     * @return the string representation of the array
     * @author Kristian Vasilev
     */
    public String print(int [] array){
        return Arrays.toString(array);
    }

    /**
     * Finds the subarray with the largest sum using Kadane's algorithm.
     *
     * @param array the array to process
     * @return the subarray with the largest sum
     * @author Kristian Vasilev
     */
    public int[] contiguousArrayLargestSum(int[] array){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int s = 0;
            for (int i = 0; i < array.length; i++) {
                maxEndingHere += array[i];

                if (maxSoFar < maxEndingHere) {
                    maxSoFar = maxEndingHere;
                    start = s;
                    end = i;
                }

                if (maxEndingHere < 0) {
                    maxEndingHere = 0;
                    s = i + 1;
                }
            }
            int[] contiguousArray = new int[end - start + 1];
            if (end + 1 - start >= 0){
                System.arraycopy(array, start, contiguousArray, 0, end + 1 - start);
            }
            return contiguousArray;

    }
}
