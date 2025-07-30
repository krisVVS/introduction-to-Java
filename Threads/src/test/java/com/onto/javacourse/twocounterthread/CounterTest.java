package com.onto.javacourse.twocounterthread;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

  @Test
  void testFasterThreadStopsSlowerThread() throws InterruptedException {
    Counter fast = new Counter("FastThread", 3, 200);
    Counter slow = new Counter("SlowThread", 10, 500);

    Thread tFast = new Thread(fast, "Fast");
    Thread tSlow = new Thread(slow, "Slow");

    fast.setPartner(tSlow);
    slow.setPartner(tFast);

    tFast.start();
    tSlow.start();

    tSlow.join();

    assertFalse(tFast.isAlive());
    assertFalse(tSlow.isAlive());
  }

  @Test
  void testSlowerThreadStopsFasterThread() throws InterruptedException {
    Counter slow = new Counter("SlowThread", 3, 500);
    Counter fast = new Counter("FastThread", 10, 200);

    Thread tSlow = new Thread(slow, "Slow");
    Thread tFast = new Thread(fast, "Fast");

    slow.setPartner(tFast);
    fast.setPartner(tSlow);

    tSlow.start();
    tFast.start();

    tFast.join();

    assertFalse(tSlow.isAlive());
    assertFalse(tFast.isAlive());
  }

  @Test
  void testBothThreadsFinishWhenCountsEqual() throws InterruptedException {
    Counter c1 = new Counter("Thread1", 5, 300);
    Counter c2 = new Counter("Thread2", 5, 300);

    Thread t1 = new Thread(c1, "T1");
    Thread t2 = new Thread(c2, "T2");

    c1.setPartner(t2);
    c2.setPartner(t1);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    assertFalse(t1.isAlive());
    assertFalse(t2.isAlive());
  }
}
