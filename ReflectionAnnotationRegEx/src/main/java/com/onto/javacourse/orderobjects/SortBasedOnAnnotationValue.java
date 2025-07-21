package com.onto.javacourse.orderobjects;

import java.util.Arrays;

/**
 * The {@code SortBasedOnAnnotationValue} class is used to sort and print an array
 * of {@link ParentClass} objects based on the value of their {@link Order} annotation.
 */
public class SortBasedOnAnnotationValue {
  private ParentClass[] objects;

  /**
   * Initializes the sorter with an array of {@link ParentClass} objects.
   *
   * @param objects the array of objects to be sorted
   */
  public SortBasedOnAnnotationValue(ParentClass[] objects) {
    this.objects = objects;
  }

  /**
   * Sorts the objects array based on the {@link Order} annotation value of each object.
   */
  public void sort() {
    Arrays.sort(objects, (o1, o2) -> Integer.compare(o1.getOrderValue(), o2.getOrderValue()));
  }

  /**
   * Prints the sorted objects' class names to the console.
   */
  public void printSortedObjects() {
    for (ParentClass obj : objects) {
      System.out.println(obj.getClass().getSimpleName());
    }
  }
}
