package com.onto.javacourse.intro.arrayreverse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayReverseTest {
  @Test
  void testArrayReverseNullArray() {
    Object[] array = null;
    ArrayReverse.arrayReverse(array);
    // Expected: No exception, warning logged
  }

  @Test
  void testArrayReverseEmptyArray() {
    Object[] array = new Object[] {};
    ArrayReverse.arrayReverse(array);
    assertArrayEquals(new Object[] {}, array);
  }

  @Test
  void testArrayReverseSingleElementArray() {
    Object[] array = new Object[] {1};
    ArrayReverse.arrayReverse(array);
    assertArrayEquals(new Object[] {1}, array);
  }

  @Test
  void testArrayReverseEvenNumberOfElements() {
    Object[] array = new Object[] {1, 2, 3, 4};
    ArrayReverse.arrayReverse(array);
    assertArrayEquals(new Object[] {4, 3, 2, 1}, array);
  }

  @Test
  void testArrayReverseOddNumberOfElements() {
    Object[] array = new Object[] {"a", "b", "c", "d", "e"};
    ArrayReverse.arrayReverse(array);
    assertArrayEquals(new Object[] {"e", "d", "c", "b", "a"}, array);
  }
}
