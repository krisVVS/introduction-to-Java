package com.onto.javacourse.synchronizedstack;

/**
 * A thread that continuously pops elements from a synchronized stack.
 */
public class RemoverThread implements Runnable {
  private final SynchronizedStack<Integer> stack;
  private final int maxRemoves;

  /**
   * Constructs a RemoverThread with the given stack and maximum number of pops.
   *
   * @param stack      the stack to pop elements from
   * @param maxRemoves the maximum number of pops
   */
  public RemoverThread(SynchronizedStack<Integer> stack, int maxRemoves) {
    this.stack = stack;
    this.maxRemoves = maxRemoves;
  }

  @Override
  public void run() {
    try {
      for (int i = 1; i <= maxRemoves; i++) {
        stack.pop();
        Thread.sleep(800);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
