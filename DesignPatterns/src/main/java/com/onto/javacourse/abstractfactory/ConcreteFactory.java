package com.onto.javacourse.abstractfactory;

/**
 * Concrete implementation of the MyClassFactory that creates instances of MyClass.
 */
public class ConcreteFactory extends MyClassFactory {

  /**
   * Creates a new instance of MyClass using the default constructor.
   *
   * @return a new instance of MyClass
   */
  @Override
  public MyClass createInstance() {
    return new MyClass();
  }

  /**
   * Creates a new instance of MyClass using reflection, based on the class name.
   *
   * @param className the fully qualified name of the class to be instantiated
   * @return a new instance of MyClass
   * @throws ClassNotFoundException if the class cannot be found
   */
  @Override
  public MyClass createInstance(String className) throws ClassNotFoundException {
    try {
      Class<?> clazz = Class.forName(className);
      return (MyClass) clazz.getDeclaredConstructor().newInstance();
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found: " + className);
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error creating instance for class: " + className, e);
    }
  }
}
