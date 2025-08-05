package com.onto.javacourse.abstractfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConcreteFactoryTest {

  @Test
  public void testCreateInstanceUsingFactoryMethod() {
    MyClassFactory factory = new ConcreteFactory();

    MyClass myClass = factory.createInstance();

    assertNotNull(myClass);
    assertEquals("Default Name", myClass.getName());
  }

  @Test
  public void testCreateInstanceUsingReflection() throws ClassNotFoundException {
    MyClassFactory factory = new ConcreteFactory();

    MyClass myClass = factory.createInstance("com.onto.javacourse.abstractfactory.MyClass");

    assertNotNull(myClass);
    assertEquals("Default Name", myClass.getName());
  }


  @Test
  public void testCreateInstanceWithNonExistentClass() {
    MyClassFactory factory = new ConcreteFactory();
    assertThrows(ClassNotFoundException.class, () -> factory.createInstance("NonExistentClass"));
  }



  @Test
  public void testCreateInstanceWithParameterizedConstructor() {
    MyClassFactory factory = new ConcreteFactory();

    MyClass myClass = new MyClass("Custom Name");

    assertNotNull(myClass);
    assertEquals("Custom Name", myClass.getName());
  }
}