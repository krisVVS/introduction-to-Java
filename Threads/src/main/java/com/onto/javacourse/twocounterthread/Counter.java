package com.onto.javacourse.twocounterthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code Counter} class represents a counter task that can be executed by a thread.
 * Each counter counts up to a configured maximum number with a specified interval.
 * When one counter finishes, it interrupts its partner counter to stop it immediately.
 */
public class Counter implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Counter.class);
  private final int maxCount;
  private final int intervalMillis;
  private final String threadName;
  private Thread partner;

  /**
   * Constructs a {@code Counter} instance.
   *
   * @param threadName     the name of the thread for logging purposes
   * @param maxCount       the maximum number this counter will count to
   * @param intervalMillis the interval in milliseconds between counts
   */
  public Counter(String threadName, int maxCount, int intervalMillis) {
    this.threadName = threadName;
    this.maxCount = maxCount;
    this.intervalMillis = intervalMillis;
  }

  /**
   * Sets the partner thread that will be interrupted when this counter finishes.
   *
   * @param partner the partner thread
   */
  public void setPartner(Thread partner) {
    this.partner = partner;
  }

  /**
   * Executes the counting task. The thread sleeps for the configured interval,
   * then prints the current count. When the maximum count is reached, the
   * partner thread is interrupted.
   */
  @Override
  public void run() {
    try {
      for (int i = 1; i <= maxCount; i++) {
        Thread.sleep(intervalMillis);
        LOGGER.info("{} count: {}", threadName, i);
      }
    } catch (InterruptedException e) {
      LOGGER.info("{} interrupted during sleep and exits.", threadName);
      return;
    }

    LOGGER.info("{} finished and stopping the other thread.", threadName);
    if (partner != null && partner.isAlive()) {
      partner.interrupt();
    }
  }
}