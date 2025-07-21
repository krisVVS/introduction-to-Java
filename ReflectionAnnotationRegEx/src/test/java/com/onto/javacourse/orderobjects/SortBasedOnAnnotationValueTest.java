package com.onto.javacourse.orderobjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for SortBasedOnAnnotationValue
public class SortBasedOnAnnotationValueTest {

  private SortBasedOnAnnotationValue sorter;
  private ParentClass[] objects;

  @BeforeEach
  void setUp() {
    objects = new ParentClass[]{
        new ClassA(),
        new ClassB(),
        new ClassC()
    };
    sorter = new SortBasedOnAnnotationValue(objects);
  }

  @Test
  void testSort() {
    sorter.sort();
    assertEquals("ClassB", objects[0].getClass().getSimpleName());
    assertEquals("ClassA", objects[1].getClass().getSimpleName());
    assertEquals("ClassC", objects[2].getClass().getSimpleName());
  }

  @Test
  void testSortWithNoAnnotation() {
    // Create a class without @Order annotation
    class ClassWithoutOrder extends ParentClass {
    }

    // Add it to the array
    ParentClass[] invalidObjects = new ParentClass[]{
        new ClassA(),
        new ClassB(),
        new ClassWithoutOrder()
    };

    // Validate exception is thrown during sort
    SortBasedOnAnnotationValue invalidSorter = new SortBasedOnAnnotationValue(invalidObjects);
    assertThrows(IllegalStateException.class, invalidSorter::sort);
  }
}
