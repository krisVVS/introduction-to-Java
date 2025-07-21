package com.onto.javacourse.abstractfactory;

/**
 * Represents a class with a name property.
 */
public class MyClass {
  private String name;

  /**
   * Constructs a MyClass object with the specified name.
   *
   * @param name the name to be set
   */
  public MyClass(String name) {
    this.name = name;
  }

  /**
   * Constructs a MyClass object with the default name "Default Name".
   */
  public MyClass() {
    this.name = "Default Name";
  }

  /**
   * Returns the name of this MyClass object.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}
