package com.onto.javacourse.objectinformationdisplayer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObjectInformationDisplayerTest {

  static class SampleClass {
    private String name = "test";
    public int number = 42;

    public String getName() {
      return name;
    }

    private void setName(String name) {
      this.name = name;
    }

    public int getNumber() {
      return number;
    }
  }

  @Test
  void testReturnClassDetails_NullObject() {
    ClassDetails result = ObjectInformationDisplayer.returnClassDetails(null);
    assertNull(result);
  }

  @Test
  void testReturnClassDetails_SampleClass() {
    SampleClass sample = new SampleClass();
    ClassDetails details = ObjectInformationDisplayer.returnClassDetails(sample);

    assertNotNull(details);
    assertEquals(SampleClass.class.getName(), details.getClassName());

    assertTrue(details.getFields().stream().anyMatch(f -> f.getName().equals("name") && f.getValue().equals("test")));
    assertTrue(details.getFields().stream().anyMatch(f -> f.getName().equals("number") && f.getValue().equals("42")));

    assertTrue(details.getMethods().stream().anyMatch(m -> m.getName().equals("getName")));
    assertTrue(details.getMethods().stream().anyMatch(m -> m.getName().equals("setName")));
    assertTrue(details.getMethods().stream().anyMatch(m -> m.getName().equals("getNumber")));

  }
}
