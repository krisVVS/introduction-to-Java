package com.onto.javacourse.proxy;

/**
 * The IntegerFactory class is responsible for creating IntegerProxy instances.
 * It acts as a factory that generates proxies for Integer objects.
 */
public class IntegerFactory {

  /**
   * Creates a new IntegerProxy instance.
   *
   * @param value The initial value for the IntegerProxy.
   * @return A new IntegerProxy instance.
   */
  public IntegerProxy createInstance(int value) {
    Integer realInteger = Integer.valueOf(value);
    return new IntegerProxy(realInteger);
  }
}
