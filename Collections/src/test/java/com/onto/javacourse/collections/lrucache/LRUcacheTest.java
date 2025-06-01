package com.onto.javacourse.collections.lrucache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LRUcacheTest {

  private LruCache<Integer, String> cache;

  @BeforeEach
  void setUp() {
    cache = new LruCache<>(3);
  }

  @Test
  void testPutAndGet() {
    cache.put(1, "One");
    cache.put(2, "Two");

    assertEquals("One", cache.get(1));
    assertEquals("Two", cache.get(2));
  }

  @Test
  void testEvictionOfLeastRecentlyUsed() {
    cache.put(1, "One");
    cache.put(2, "Two");
    cache.put(3, "Three");

    cache.get(1);

    cache.put(4, "Four");

    assertFalse(cache.containsKey(2));
    assertTrue(cache.containsKey(1));
    assertTrue(cache.containsKey(3));
    assertTrue(cache.containsKey(4));
  }

  @Test
  void testUpdateValue() {
    cache.put(1, "One");
    cache.put(1, "Uno");

    assertEquals("Uno", cache.get(1));
  }

  @Test
  void testContainsKey() {
    cache.put(5, "Five");

    assertTrue(cache.containsKey(5));
    assertFalse(cache.containsKey(10));
  }

  @Test
  void testEvictionOrder() {
    cache.put(1, "A");
    cache.put(2, "B");
    cache.put(3, "C");

    cache.get(1);
    cache.get(2);

    cache.put(4, "D");

    assertFalse(cache.containsKey(3));
    assertTrue(cache.containsKey(1));
    assertTrue(cache.containsKey(2));
    assertTrue(cache.containsKey(4));
  }

  @Test
  void testDisplayOutput() {
    LruCache<Integer, String> cache = new LruCache<>(2);
    cache.put(1, "One");
    cache.put(2, "Two");

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(output));

    cache.display();

    System.setOut(originalOut);

    String outputText = output.toString().trim();
    assertTrue(outputText.contains("Current Cache:"));
    assertTrue(outputText.contains("1 => One"));
    assertTrue(outputText.contains("2 => Two"));
  }
}
