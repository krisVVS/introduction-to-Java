package com.onto.javacourse.intro.arrayreverse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayReverse {
    private static final Logger log = LoggerFactory.getLogger(ArrayReverse.class);

    /**
     * Reverses the order of elements in the given array.
     *
     * @param array the array to reverse; may be {@code null}
     */
    public static void arrayReverse(Object[] array) {
        if (array == null) {
            log.warn("The array is null");
            return; // Return immediately if the array is null
        }

        int length = array.length;
        Object temp;
        for (int i = 0; i < length / 2; i++) {
            temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}
