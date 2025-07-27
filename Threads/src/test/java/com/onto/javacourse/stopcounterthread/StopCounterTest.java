package com.onto.javacourse.stopcounterthread;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopCounterTest {

  @Test
  void testCounterFinishesSuccessfully() throws InterruptedException {
    AtomicBoolean finished = new AtomicBoolean(false);

    CounterListener listener = () -> finished.set(true);
    StopCounter counter = new StopCounter(2, listener);
    Thread thread = new Thread(counter);
    thread.start();
    thread.join();

    assertTrue(finished.get());
  }

  @Test
  void testCounterInterruptedEarly() throws InterruptedException {
    AtomicBoolean finished = new AtomicBoolean(false);

    CounterListener listener = () -> finished.set(true);
    StopCounter counter = new StopCounter(10, listener);
    Thread thread = new Thread(counter);
    thread.start();

    Thread.sleep(2000);
    thread.interrupt();
    thread.join();

    assertTrue(!finished.get());
  }

  @Test
  void testCounterIsInterruptedWhenEnterPressed() throws InterruptedException {
    ByteArrayInputStream input = new ByteArrayInputStream(System.lineSeparator().getBytes());
    Scanner scanner = new Scanner(input);
    AtomicBoolean exitCalled = new AtomicBoolean(false);
    Runnable exitHandler = () -> exitCalled.set(true);
    Thread testThread = new Thread(() -> StarterThread.begin(10, scanner, exitHandler));
    testThread.start();

    Thread.sleep(500);

    assertFalse(exitCalled.get());
    testThread.join();
  }
}
