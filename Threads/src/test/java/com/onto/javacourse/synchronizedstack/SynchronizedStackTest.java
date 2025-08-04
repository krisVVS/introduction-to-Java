package com.onto.javacourse.synchronizedstack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SynchronizedStackTest {

  @Test
  void testPushAndPopSingleThread() throws InterruptedException {
    SynchronizedStack<Integer> stack = new SynchronizedStack<>(2);

    stack.push(1);
    stack.push(2);

    assertEquals(2, stack.pop(), "Last pushed element should be popped first");
    assertEquals(1, stack.pop(), "Stack should follow LIFO order");
  }

  @Test
  void testPopBlocksWhenEmpty() throws InterruptedException {
    SynchronizedStack<Integer> stack = new SynchronizedStack<>(1);

    Thread consumer = new Thread(() -> {
      try {
        stack.pop();
      } catch (InterruptedException ignored) {}
    });

    consumer.start();
    Thread.sleep(200);

    assertTrue(consumer.isAlive(), "Consumer should be waiting when stack is empty");

    stack.push(42);
    Thread.sleep(200);

    assertFalse(consumer.isAlive(), "Consumer should finish after element is pushed");
  }

  @Test
  void testPushBlocksWhenFull() throws InterruptedException {
    SynchronizedStack<Integer> stack = new SynchronizedStack<>(1);
    stack.push(1);

    Thread producer = new Thread(() -> {
      try {
        stack.push(2);
      } catch (InterruptedException ignored) {}
    });

    producer.start();
    Thread.sleep(200);

    assertTrue(producer.isAlive(), "Producer should be waiting when stack is full");

    stack.pop();
    Thread.sleep(200);

    assertFalse(producer.isAlive(), "Producer should finish after element is popped");
  }

  @Test
  void testProducerConsumerThreads() throws InterruptedException {
    SynchronizedStack<Integer> stack = new SynchronizedStack<>(3);

    Thread producer = new Thread(new AdderThread(stack, 5), "Producer");
    Thread consumer = new Thread(new RemoverThread(stack, 5), "Consumer");

    producer.start();
    consumer.start();

    producer.join(5000);
    consumer.join(5000);

    assertFalse(producer.isAlive(), "Producer should have completed");
    assertFalse(consumer.isAlive(), "Consumer should have completed");
  }
}
