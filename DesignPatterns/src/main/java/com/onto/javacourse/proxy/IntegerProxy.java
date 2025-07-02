package com.onto.javacourse.proxy;

/**
 * The IntegerProxy class represents a proxy for an Integer object.
 * It encapsulates the real Integer object and provides methods to interact with it.
 */
public class IntegerProxy {

  private Integer realInteger;

  /**
   * Constructs an IntegerProxy object with a real Integer.
   *
   * @param realInteger The real Integer object to be proxied.
   */
  public IntegerProxy(Integer realInteger) {
    this.realInteger = realInteger;
  }

  /**
   * Returns the value of the proxied Integer object.
   *
   * @return The value of the proxied Integer object.
   */
  public int getValue() {
    return realInteger.intValue();
  }

  /**
   * Sets the value of the proxied Integer object.
   *
   * @param value The new value to set.
   */
  public void setValue(int value) {
    realInteger = value;
  }

  /**
   * Returns a string representation of the IntegerProxy object.
   *
   * @return A string representing the IntegerProxy object.
   */
  @Override
  public String toString() {
    return "IntegerProxy{value=" + realInteger + '}';
  }
}
