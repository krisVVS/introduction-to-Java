package com.onto.javacourse.abstractfactory;

/**
 * Abstract factory for creating instances of MyClass.
 */
public abstract class MyClassFactory {

  /**
   * Creates a new instance of MyClass.
   *
   * @return a new instance of MyClass
   */
  public abstract MyClass createInstance();

  /**
   * Creates a new instance of MyClass using reflection based on the class name.
   *
   * @param className the fully qualified name of the class to be instantiated
   * @return a new instance of MyClass
   * @throws ClassNotFoundException if the class cannot be found
   */
  public abstract MyClass createInstance(String className) throws ClassNotFoundException;
}