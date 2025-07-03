package com.onto.javacourse.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void testSingletonInstance() {
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    assertSame(singleton1, singleton2);
  }

  @Test
  void testSingletonCreation() {
    Singleton singleton = Singleton.getInstance();
    assertNotNull(singleton);
  }
}
