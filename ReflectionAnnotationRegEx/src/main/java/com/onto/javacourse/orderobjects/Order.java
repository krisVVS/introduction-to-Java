package com.onto.javacourse.orderobjects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code Order} annotation is used to define the sorting order of a class.
 * It takes an integer value to specify the order.
 *
 * <p>Example:</p>
 * <pre>
 * {@literal @}Order(1)
 * public class ClassA {
 * }
 * </pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
  /**
   * The order value for the annotated class.
   *
   * @return the sorting order as an integer
   */
  int value();
}
