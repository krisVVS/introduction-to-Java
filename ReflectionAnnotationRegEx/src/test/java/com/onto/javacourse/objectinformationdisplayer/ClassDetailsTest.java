package com.onto.javacourse.objectinformationdisplayer;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClassDetailsTest {

  @Test
  void testConstructorAndGetters() {
    ClassDetails classDetails = new ClassDetails("TestClass");

    assertEquals("TestClass", classDetails.getClassName());
    assertTrue(classDetails.getFields().isEmpty());
    assertTrue(classDetails.getMethods().isEmpty());
  }

  @Test
  void testAddField() {
    ClassDetails classDetails = new ClassDetails("TestClass");

    ClassDetails.FieldDetail field = new ClassDetails.FieldDetail("private", "String", "name", "John");
    classDetails.addField(field);

    List<ClassDetails.FieldDetail> fields = classDetails.getFields();
    assertEquals(1, fields.size());
    assertEquals("name", fields.get(0).getName());
  }

  @Test
  void testAddMethod() {
    ClassDetails classDetails = new ClassDetails("TestClass");

    ClassDetails.MethodDetail method = new ClassDetails.MethodDetail("public", "void", "doSomething", "int");
    classDetails.addMethod(method);

    List<ClassDetails.MethodDetail> methods = classDetails.getMethods();
    assertEquals(1, methods.size());
    assertEquals("doSomething", methods.get(0).getName());
  }

  @Test
  void testFieldDetailGetters() {
    ClassDetails.FieldDetail field = new ClassDetails.FieldDetail("private", "int", "age", "25");
    assertEquals("private", field.getModifier());
    assertEquals("int", field.getType());
    assertEquals("age", field.getName());
    assertEquals("25", field.getValue());
  }

  @Test
  void testMethodDetailGetters() {
    ClassDetails.MethodDetail method = new ClassDetails.MethodDetail("public", "String", "getName", "int, String");
    assertEquals("public", method.getModifier());
    assertEquals("String", method.getReturnType());
    assertEquals("getName", method.getName());
    assertEquals("int, String", method.getParameters());
  }
}
