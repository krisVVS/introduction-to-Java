package com.onto.javacourse.synchronizedthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A runnable task where two threads alternate printing their counts.
 * Each thread counts up to its own maximum, taking turns to ensure
 * ordered output. When one thread finishes, the other continues until
 * it completes its count.
 */
public class CounterSynchronized implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(CounterSynchronized.class);
  private static final Object lock = new Object();

  private static int threadCounter = 0;
  private static int turn = 0;
  private static boolean[] done = new boolean[2];

  private int personalCount = 1;
  private final int personalMaxCount;
  private final int intervalMillis;
  private final int threadIndex;
  private final String displayName;

  /**
   * Creates a new counter task.
   *
   * @param displayName      thread name for logging
   * @param personalMaxCount maximum number this thread counts to
   * @param intervalMillis   delay between prints in milliseconds
   */
  public CounterSynchronized(String displayName, int personalMaxCount, int intervalMillis) {
    this.displayName = displayName;
    this.personalMaxCount = personalMaxCount;
    this.intervalMillis = intervalMillis;
    synchronized (CounterSynchronized.class) {
      this.threadIndex = threadCounter++;
    }
  }

  /**
   * Alternates printing numbers with another thread until
   * this thread reaches its maximum count.
   */
  @Override
  public void run() {
    while (personalCount <= personalMaxCount) {
      synchronized (lock) {
        while (turn != threadIndex && !done[1 - threadIndex]) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            LOGGER.info("{} interrupted and exiting.", displayName);
            return;
          }
        }

        if (personalCount > personalMaxCount) {
          done[threadIndex] = true;
          lock.notifyAll();
          break;
        }

        LOGGER.info("{} - {}", displayName, personalCount);

        try {
          Thread.sleep(intervalMillis);
        } catch (InterruptedException e) {
          LOGGER.info("{} interrupted during sleep and exiting.", displayName);
          return;
        }

        personalCount++;

        if (personalCount > personalMaxCount) {
          done[threadIndex] = true;
        }

        if (!done[1 - threadIndex]) {
          turn = 1 - threadIndex;
        }

        lock.notifyAll();
      }
    }
    LOGGER.info("{} finished counting.", displayName);
  }
}
