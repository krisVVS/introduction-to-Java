package com.onto.javacourse.stopcounterthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A runnable counter that counts once per second up to a specified number.
 * After counting, it notifies a listener if one is provided.
 */
public class StopCounter implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StopCounter.class);
  private final int counter;
  private final CounterListener listener;

  /**
   * Constructs a StopCounter with a given count limit and optional listener.
   *
   * @param counter  the number of seconds to count
   * @param listener a listener to be notified when counting finishes, or null
   */
  public StopCounter(int counter, CounterListener listener) {
    this.counter = counter;
    this.listener = listener;
  }

  /**
   * Runs the counter. Logs each count once per second.
   * If the counting completes, the listener is notified.
   * If interrupted, the counter stops early.
   */
  @Override
  public void run() {
    try {
      for (int i = 1; i <= counter; i++) {
        Thread.sleep(1000);
        LOGGER.info("Counter: " + i);
      }
      LOGGER.info("Counter finished.");
      if (listener != null) {
        listener.onCounterFinished();
      }
    } catch (InterruptedException e) {
      LOGGER.info("Counter interrupted.");
    }
  }
}
