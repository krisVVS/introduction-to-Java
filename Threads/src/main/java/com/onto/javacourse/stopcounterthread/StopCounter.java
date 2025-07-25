package com.onto.javacourse.stopcounterthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopCounter implements Runnable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StopCounter.class);
  private int counter;
  public StopCounter(int counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 1; i <= counter; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        if(i==counter) {
          LOGGER.info("Times up " + Thread.currentThread().getName() + " " + i);
          System.exit(0);
        }
    }
  }
}
