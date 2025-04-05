package com.onto.javacourse.listofelements;

import com.onto.javacourse.between0n100.EmptyListException;
import com.onto.javacourse.between0n100.FullListException;
import java.util.Arrays;

/** A fixed-size list that allows adding and removing elements. */
public class ElementList {
  private Object[] elements;
  private int size;

  /**
   * Constructs an ElementList with the specified length.
   *
   * @param length the maximum number of elements the list can hold
   * @throws IllegalArgumentException if the length is less than or equal to 0
   */
  public ElementList(int length) {
    if (length <= 0) {
      throw new IllegalArgumentException("Length must be greater than 0");
    }
    this.elements = new Object[length];
    this.size = 0;
  }

  /**
   * Adds an element to the list.
   *
   * @param obj the element to be added
   * @throws FullListException if the list is full
   */
  public void add(Object obj) {
    if (size == elements.length) {
      throw new FullListException("Cannot add element: The list is full.");
    }
    elements[size] = obj;
    size++;
  }

  /**
   * Removes the last element from the list.
   *
   * @throws EmptyListException if the list is empty
   */
  public void remove() {
    if (size == 0) {
      throw new EmptyListException("Cannot remove element: The list is empty.");
    }
    elements[size - 1] = null; // Optional: clear the reference
    size--;
  }

  /**
   * Returns a string representation of the list.
   *
   * @return a string representation of the elements in the list
   */
  @Override
  public String toString() {
    return "FixedSizeList{" + "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) + '}';
  }
}
