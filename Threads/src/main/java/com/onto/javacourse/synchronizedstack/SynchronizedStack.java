package com.onto.javacourse.synchronizedstack;

import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A thread-safe stack with blocking push and pop operations.
 * If the stack is full, push waits until space is available.
 * If the stack is empty, pop waits until an element is added.
 *
 * @param <T> the type of elements in this stack
 */
public class SynchronizedStack<T> {
  private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedStack.class);

  private final List<T> stack;
  private final int capacity;

  /**
   * Constructs a synchronized stack with the given capacity.
   *
   * @param capacity the maximum number of elements the stack can hold
   */
  public SynchronizedStack(int capacity) {
    this.capacity = capacity;
    this.stack = new LinkedList<>();
  }

  /**
   * Pushes an element onto the stack, waiting if necessary until space is available.
   *
   * @param item the element to add
   * @throws InterruptedException if interrupted while waiting
   */
  public synchronized void push(T item) throws InterruptedException {
    while (stack.size() == capacity) {
      LOGGER.info("Stack full. Waiting to push...");
      wait();
    }
    stack.add(item);
    LOGGER.info("Pushed: {}", item);
    notifyAll();
  }

  /**
   * Pops the top element from the stack, waiting if necessary until an element is available.
   *
   * @return the removed element
   * @throws InterruptedException if interrupted while waiting
   */
  public synchronized T pop() throws InterruptedException {
    while (stack.isEmpty()) {
      LOGGER.info("Stack empty. Waiting to pop...");
      wait();
    }
    T item = stack.remove(stack.size() - 1);
    LOGGER.info("Popped: {}", item);
    notifyAll();
    return item;
  }
}
