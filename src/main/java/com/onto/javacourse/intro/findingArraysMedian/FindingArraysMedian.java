package com.onto.javacourse.intro.findingArraysMedian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindingArraysMedian
{
    private static final Logger log = LoggerFactory.getLogger(FindingArraysMedian .class);


    /**
     * Calculates the 1-based position of the median in the given array.
     * <p>
     * For arrays with length 1, it returns 1 as the only element is considered the median.
     * For arrays with length 2 or 0, it returns -1 as a median cannot be properly determined.
     * For other cases, it invokes the {@link #findMedian(int[])} method to find the position.
     *
     * @param array the array of integers to find the median of
     * @return the 1-based index of the median, or -1 if the median cannot be determined
     * @author Kristian Vasilev
     */
    public int median(int[] array) {
        if (array.length == 1) {
            return 1;
        }
        if (array.length == 2 || array.length == 0) {
            log.warn("Cannot determine the median of an array");
            return -1;
        }

        return findMedian(array);
    }

    /**
     * Finds the position of the median in the array where the difference between the sum of elements
     * before and after the median is minimized.
     * <p>
     * This method calculates sums of elements to the left and right of potential median positions,
     * adjusting the median position to balance the sums as closely as possible.
     *
     * @param array the array of integers to find the median of
     * @return the 1-based index of the median position in the array
     * @author Kristian Vasilev
     */
    private int findMedian(int[] array) {
        int m = array.length / 2;
        int result = 0;
        int diff = Integer.MAX_VALUE;
        boolean flag = true;

        while (flag) {
            if (m == 0 || m == array.length - 1) {
                return result;
            }

            int leftSum = calculateSum(array, 0, m);
            int rightSum = calculateSum(array, m + 1, array.length);
            int diffCheck = leftSum - rightSum;

            if (Math.abs(diffCheck) < Math.abs(diff)) {
                diff = diffCheck;
                result = m + 1;

                if (diff < 0) {
                    m += 1;
                } else {
                    m -= 1;
                }
            } else {
                flag = false;
            }
        }
        return result;
    }

    /**
     * Calculates the sum of elements in the array from the start index (inclusive) to the end index (exclusive).
     *
     * @param array the array of integers
     * @param start the starting index (inclusive)
     * @param end the ending index (exclusive)
     * @return the sum of elements from {@code start} to {@code end} in the array
     * @author Kristian Vasilev
     */
    private int calculateSum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
