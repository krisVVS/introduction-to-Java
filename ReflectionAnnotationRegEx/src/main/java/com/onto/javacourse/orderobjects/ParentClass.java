package com.onto.javacourse.orderobjects;

/**
 * ParentClass provides a method to retrieve the value of the {@link Order} annotation
 * applied to its subclasses. Subclasses must have the {@link Order} annotation.
 */
abstract class ParentClass {
  /**
   * Retrieves the order value from the {@link Order} annotation of the subclass.
   *
   * @return the order value of the subclass
   * @throws IllegalStateException if the subclass does not have the {@link Order} annotation
   */
  public int getOrderValue() {
    Order order = this.getClass().getAnnotation(Order.class);
    if (order != null) {
      return order.value();
    }
    throw new IllegalStateException("The class must have an @Order annotation");
  }
}
