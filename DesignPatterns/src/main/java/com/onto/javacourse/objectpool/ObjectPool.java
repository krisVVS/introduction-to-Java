package com.onto.javacourse.objectpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A generic object pool that manages the allocation and release of resources.
 *
 * @param <T> the type of objects in the pool
 */
public class ObjectPool<T> {

  private final int maxSize;
  private final Queue<T> pool;
  private final Class<T> clazz;

  /**
   * Constructs an ObjectPool with the specified class type and maximum size.
   *
   * @param clazz the class type of objects to manage in the pool
   * @param maxSize the maximum number of objects allowed in the pool
   */
  public ObjectPool(Class<T> clazz, int maxSize) {
    this.clazz = clazz;
    this.maxSize = maxSize;
    this.pool = new LinkedList<>();
  }

  /**
   * Acquires an object from the pool. If the pool is full, an exception is thrown.
   *
   * @return an object from the pool or a newly created instance if the pool is empty
   * @throws Exception if no resources are available in the pool
   */
  public T acquire() throws Exception {
    if (pool.size() == maxSize) {
      throw new Exception("No free resources available in the pool");
    }

    if (pool.isEmpty()) {
      T instance = clazz.getDeclaredConstructor().newInstance();
      return instance;
    }

    return pool.poll();
  }

  /**
   * Releases an object back to the pool.
   *
   * @param object the object to release back to the pool
   */
  public void release(T object) {
    if (pool.size() < maxSize) {
      pool.offer(object);
    }
  }
}
