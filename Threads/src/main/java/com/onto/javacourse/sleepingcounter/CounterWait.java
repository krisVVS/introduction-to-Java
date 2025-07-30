package com.onto.javacourse.sleepingcounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code CounterWait} class is a counter task that demonstrates thread
 * synchronization using the {@link Object#wait(long)} method. Unlike using
 * {@link Thread#sleep(long)}, this implementation requires a shared lock object
 * and ensures that threads can be interrupted immediately without introducing
 * artificial delays.
 *
 * <p>Each thread counts up to a configured maximum number, waiting for a
 * specified interval between increments. When one counter finishes its sequence,
 * it interrupts its partner to stop it promptly.</p>
 */
public class CounterWait implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(CounterWait.class);

  private final int maxCount;
  private final int intervalMillis;
  private final String threadName;
  private Thread partner;
  private final Object lock;

  /**
   * Constructs a {@code CounterWait} instance.
   *
   * @param threadName     the name of the thread for logging
   * @param maxCount       the maximum count this thread will reach
   * @param intervalMillis the time interval in milliseconds between counts
   * @param lock           the shared lock object used for {@code wait()}
   */
  public CounterWait(String threadName, int maxCount, int intervalMillis, Object lock) {
    this.threadName = threadName;
    this.maxCount = maxCount;
    this.intervalMillis = intervalMillis;
    this.lock = lock;
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
   * Executes the counting logic. The thread enters a synchronized block on the
   * shared lock, waits for the configured interval, checks for interruption,
   * and logs the current count. If interrupted, the thread terminates early.
   * Upon completing its maximum count, the thread interrupts its partner.
   */
  @Override
  public void run() {
    try {
      for (int i = 1; i <= maxCount; i++) {
        synchronized (lock) {
          lock.wait(intervalMillis);
          LOGGER.info("{} count: {}", threadName, i);
        }
      }
    } catch (InterruptedException e) {
      LOGGER.info("{} interrupted during wait and exits.", threadName);
      return;
    }

    LOGGER.info("{} finished and stopping the other thread.", threadName);
    if (partner != null && partner.isAlive()) {
      partner.interrupt();
    }
  }
}
