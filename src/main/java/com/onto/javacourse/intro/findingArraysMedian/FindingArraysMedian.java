package com.onto.javacourse.intro.findingArraysMedian;
import com.onto.javacourse.intro.arrayprocessing.ArrayProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindingArraysMedian extends ArrayProcessing
{
    private static final Logger log = LoggerFactory.getLogger(FindingArraysMedian.class);

    /**
     * Finds the position of the median in the array where the difference between the sum of elements
     * before and after the median is minimized.
     * <p>
     * This method calculates sums of elements to the left and right of potential median positions,
     * adjusting the median position to balance the sums as closely as possible.
     *
     * @param array the input array of integers
     * @return the index of the median element if it can be determined, or -1 if the array
     * has two or 0 elements
     */
    public int findMedian(int[] array) {
        if (array.length == 1) {
            return 1;
        }
        if (array.length <= 2) {
            log.warn("Cannot determine the median of an array");
            return -1;
        }

        int medianIndex = array.length / 2;
        int result = 0;
        int diff = Integer.MAX_VALUE;
        int totalSum = sum(array);
        int leftSum = sum(array, medianIndex);
        int rightSum = totalSum - leftSum - array[medianIndex];

        while (medianIndex != 0 && medianIndex != array.length - 1) {
            int diffCheck = leftSum - rightSum;

            if (Math.abs(diffCheck) < Math.abs(diff)) {
                diff = diffCheck;
                result = medianIndex + 1;

                if (diff < 0) {
                    rightSum -= array[medianIndex];
                    leftSum += array[medianIndex - 1];
                    medianIndex += 1;
                } else {
                    rightSum += array[medianIndex];
                    leftSum -= array[medianIndex - 1];
                    medianIndex -= 1;
                }
            } else {
                break;
            }
        }

        return result;
    }
    /**
     * Calculates the sum of elements in the array from the start index (inclusive) to the end index (exclusive).
     *
     * @param array the array of integers
     * @param end the ending index (exclusive)
     * @return the sum of elements from {@code start} to {@code end} in the array
     * @author Kristian Vasilev
     */
    private int sum(int[] array, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
