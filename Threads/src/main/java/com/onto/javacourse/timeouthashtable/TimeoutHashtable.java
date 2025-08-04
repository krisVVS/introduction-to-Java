package com.onto.javacourse.timeouthashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A hashtable where entries expire after a configured timeout
 * unless they are accessed with put() or get().
 */
public class TimeoutHashtable {

  private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutHashtable.class);

  private static class ValueWrapper {
    Object value;
    long lastAccessed;

    ValueWrapper(Object value, long lastAccessed) {
      this.value = value;
      this.lastAccessed = lastAccessed;
    }
  }

  private final Hashtable<String, ValueWrapper> table;
  private final long timeoutMillis;
  private final ScheduledExecutorService scheduler;

  /**
   * Constructs a TimeoutHashtable with the given timeout.
   *
   * @param timeoutMillis time in milliseconds before an unused entry is removed
   */
  public TimeoutHashtable(long timeoutMillis) {
    this.table = new Hashtable<>();
    this.timeoutMillis = timeoutMillis;
    this.scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(this::cleanupTask,
        timeoutMillis / 2, timeoutMillis / 2, TimeUnit.MILLISECONDS);
    LOGGER.info("TimeoutHashtable started with timeout {} ms", timeoutMillis);
  }

  /**
   * Stores the value for the given key. Replaces the old value if the key already exists.
   *
   * @param key   the key to store the value under
   * @param value the value to store
   */
  public synchronized void put(String key, Object value) {
    table.put(key, new ValueWrapper(value, System.currentTimeMillis()));
    LOGGER.info("Put key '{}' with value '{}'", key, value);
  }

  /**
   * Returns the value for the given key or null if not present.
   * Resets the last accessed time if found.
   *
   * @param key the key to look up
   * @return the stored value or null if not found
   */
  public synchronized Object get(String key) {
    ValueWrapper wrapper = table.get(key);
    if (wrapper == null) {
      LOGGER.info("Get key '{}' -> not found", key);
      return null;
    }
    wrapper.lastAccessed = System.currentTimeMillis();
    LOGGER.info("Get key '{}' -> value '{}'", key, wrapper.value);
    return wrapper.value;
  }

  /**
   * Removes the value for the given key if present.
   *
   * @param key the key to remove
   * @return the removed value or null if not present
   */
  public synchronized Object remove(String key) {
    ValueWrapper wrapper = table.remove(key);
    if (wrapper == null) {
      LOGGER.info("Remove key '{}' -> not found", key);
      return null;
    }
    LOGGER.info("Remove key '{}' -> removed value '{}'", key, wrapper.value);
    return wrapper.value;
  }

  private void cleanupTask() {
    long now = System.currentTimeMillis();
    synchronized (this) {
      Iterator<Map.Entry<String, ValueWrapper>> it = table.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, ValueWrapper> entry = it.next();
        if (now - entry.getValue().lastAccessed > timeoutMillis) {
          LOGGER.info("Key '{}' expired and removed", entry.getKey());
          it.remove();
        }
      }
    }
  }

  /**
   * Shuts down the scheduled cleanup task.
   */
  public void shutdown() {
    scheduler.shutdownNow();
    LOGGER.info("TimeoutHashtable scheduler stopped");
  }
}
