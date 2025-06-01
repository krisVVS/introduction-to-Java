package com.onto.javacourse.listOfElements;

import com.onto.javacourse.between0n100.EmptyListException;
import com.onto.javacourse.between0n100.FullListException;
import com.onto.javacourse.listofelements.ElementList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementListTest {

  private ElementList elementList;

  @BeforeEach
  void setUp() {
    elementList = new ElementList(3); // Initialize the list with size 3
  }

  @Test
  void testAddElementsSuccessfully() {
    elementList.add("A");
    elementList.add("B");
    elementList.add("C");

    assertEquals("FixedSizeList{elements=[A, B, C]}", elementList.toString());
  }

  @Test
  void testAddElementWhenFull() {
    elementList.add("A");
    elementList.add("B");
    elementList.add("C");

    FullListException exception =
        assertThrows(
            FullListException.class,
            () -> {
              elementList.add("D");
            });

    assertEquals("Cannot add element: The list is full.", exception.getMessage());
  }

  @Test
  void testRemoveElementSuccessfully() {
    elementList.add("A");
    elementList.add("B");

    elementList.remove();

    assertEquals("FixedSizeList{elements=[A]}", elementList.toString());
  }

  @Test
  void testRemoveElementWhenEmpty() {
    EmptyListException exception =
        assertThrows(
            EmptyListException.class,
            () -> {
              elementList.remove();
            });

    assertEquals("Cannot remove element: The list is empty.", exception.getMessage());
  }

  @Test
  void testToStringWithEmptyList() {
    assertEquals("FixedSizeList{elements=[]}", elementList.toString());
  }

  @Test
  void testAddAndRemoveMix() {
    elementList.add("A");
    elementList.add("B");
    elementList.remove();
    elementList.add("C");

    assertEquals("FixedSizeList{elements=[A, C]}", elementList.toString());
  }

  @Test
  void testConstructorInvalidLength() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new ElementList(0);
            });

    assertEquals("Length must be greater than 0", exception.getMessage());
  }
}
