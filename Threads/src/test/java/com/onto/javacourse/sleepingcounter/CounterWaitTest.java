package com.onto.javacourse.sleepingcounter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterWaitTest {

  @Test
  void testFasterThreadStopsSlowerThread() throws InterruptedException {
    Object lock = new Object();

    CounterWait fast = new CounterWait("Fast", 3, 200, lock);
    CounterWait slow = new CounterWait("Slow", 10, 500, lock);

    Thread tFast = new Thread(fast, "FastThread");
    Thread tSlow = new Thread(slow, "SlowThread");

    fast.setPartner(tSlow);
    slow.setPartner(tFast);

    long start = System.currentTimeMillis();

    tFast.start();
    tSlow.start();

    tFast.join(5000);
    tSlow.join(5000);

    long elapsed = System.currentTimeMillis() - start;

    assertFalse(tFast.isAlive());
    assertFalse(tSlow.isAlive());
    assertTrue(elapsed < 6000);
  }

  @Test
  void testSlowerThreadStopsFasterThread() throws InterruptedException {
    Object lock = new Object();

    CounterWait slow = new CounterWait("Slow", 3, 500, lock);
    CounterWait fast = new CounterWait("Fast", 10, 200, lock);

    Thread tSlow = new Thread(slow, "SlowThread");
    Thread tFast = new Thread(fast, "FastThread");

    slow.setPartner(tFast);
    fast.setPartner(tSlow);

    long start = System.currentTimeMillis();

    tSlow.start();
    tFast.start();

    tSlow.join(5000);
    tFast.join(5000);

    long elapsed = System.currentTimeMillis() - start;

    assertFalse(tSlow.isAlive());
    assertFalse(tFast.isAlive());
    assertTrue(elapsed < 6000);
  }

  @Test
  void testBothFinishWhenEqualCounts() throws InterruptedException {
    Object lock = new Object();

    CounterWait c1 = new CounterWait("Thread1", 5, 300, lock);
    CounterWait c2 = new CounterWait("Thread2", 5, 300, lock);

    Thread t1 = new Thread(c1, "T1");
    Thread t2 = new Thread(c2, "T2");

    c1.setPartner(t2);
    c2.setPartner(t1);

    t1.start();
    t2.start();

    t1.join(5000);
    t2.join(5000);

    assertFalse(t1.isAlive());
    assertFalse(t2.isAlive());
  }
}
