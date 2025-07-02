package com.onto.javacourse.proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerProxyTest {

  private IntegerFactory factory;

  @BeforeEach
  public void setUp() {
    factory = new IntegerFactory();
  }

  @Test
  public void testIntegerProxyCreation() {
    IntegerProxy proxy = factory.createInstance(10);

    assertNotNull(proxy);
    assertEquals(10, proxy.getValue());
  }

  @Test
  public void testIntegerProxySetValue() {
    IntegerProxy proxy = factory.createInstance(10);

    proxy.setValue(20);

    assertEquals(20, proxy.getValue());
  }

  @Test
  public void testIntegerProxyToString() {
    IntegerProxy proxy = factory.createInstance(15);

    String expected = "IntegerProxy{value=15}";
    assertEquals(expected, proxy.toString());
  }

  @Test
  public void testIntegerFactoryCreatesCorrectProxy() {
    IntegerProxy proxy = factory.createInstance(30);

    assertNotNull(proxy);
    assertEquals(30, proxy.getValue());
  }
}
