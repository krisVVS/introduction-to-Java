package com.onto.javacourse.collections.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple generic implementation of an LRU (Least Recently Used) cache.
 * When the cache exceeds its capacity, it removes the least recently accessed item.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class LruCache<K, V> {

  private final int capacity;
  private final Map<K, V> cache;

  /**
   * Creates a new LRU cache with the specified capacity.
   *
   * @param capacity the maximum number of items the cache can hold
   */
  public LruCache(int capacity) {
    this.capacity = capacity;

    this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > LruCache.this.capacity;
      }
    };
  }

  /**
   * Returns the value for the given key, or null if the key is not present.
   *
   * @param key the key to search for
   * @return the value associated with the key, or null if not found
   */
  public V get(K key) {
    return cache.getOrDefault(key, null);
  }

  /**
   * Inserts or updates the key-value pair in the cache.
   *
   * @param key the key to add or update
   * @param value the value to associate with the key
   */
  public void put(K key, V value) {
    cache.put(key, value);
  }

  /**
   * Prints the contents of the cache to the console.
   * Items are displayed from least to most recently used.
   */
  public void display() {
    System.out.println("Current Cache: ");
    cache.forEach((k, v) -> System.out.println(k + " => " + v));
  }

  /**
   * Checks whether the cache contains the given key.
   *
   * @param key the key to check for
   * @return true if the key is present, false otherwise
   */
  public boolean containsKey(K key) {
    return cache.containsKey(key);
  }
}
