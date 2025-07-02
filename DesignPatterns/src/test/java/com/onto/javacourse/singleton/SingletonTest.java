package com.onto.javacourse.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void testSingletonInstance() {
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    assertSame(singleton1, singleton2, "Both instances should be the same");
  }

  @Test
  void testSingletonCreation() {
    Singleton singleton = Singleton.getInstance();
    assertNotNull(singleton, "Singleton instance should not be null");
  }
}
