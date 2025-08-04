package com.onto.javacourse.synchronizedstack;

/**
 * A thread that continuously pushes elements into a synchronized stack.
 */
public class AdderThread implements Runnable {
  private final SynchronizedStack<Integer> stack;
  private final int maxAdds;

  /**
   * Constructs an AdderThread with the given stack and maximum number of pushes.
   *
   * @param stack   the stack to push elements into
   * @param maxAdds the maximum number of pushes
   */
  public AdderThread(SynchronizedStack<Integer> stack, int maxAdds) {
    this.stack = stack;
    this.maxAdds = maxAdds;
  }

  @Override
  public void run() {
    try {
      for (int i = 1; i <= maxAdds; i++) {
        stack.push(i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
