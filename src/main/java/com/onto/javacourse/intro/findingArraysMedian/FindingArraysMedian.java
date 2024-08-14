package com.onto.javacourse.intro.findingArraysMedian;

import com.onto.javacourse.intro.arrayprocessing.ArrayProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindingArraysMedian extends ArrayProcessing {
    private static final Logger log = LoggerFactory.getLogger(FindingArraysMedian.class);

    /**
     * Finds the 1-based index in the array that balances the sums of elements
     * on either side of the index as much as possible.
     *
     * <p>The position is 1-based, meaning that the first position in the array is 1.</p>
     *
     * <p>If the array has only one element, the method returns 1 as there is no meaningful
     * median position in a single-element array.</p>
     *
     * <p>If the array has two or fewer elements, the method logs a warning and returns -1
     * because a median cannot be determined in such cases.</p>
     *
     * @param array The input array of integers. The array must contain at least 3 elements
     *              for a valid median calculation.
     * @return The 1-based index of the position that results in the most balanced partition.
     *         Returns -1 if the array length is less than 3.
     */
    public int findMedian(int[] array) {
        int n = array.length;

        if (n == 1) {
            return 1;
        }

        if (n <= 2) {
            log.warn("Cannot determine the median of an array with less than 3 elements");
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
