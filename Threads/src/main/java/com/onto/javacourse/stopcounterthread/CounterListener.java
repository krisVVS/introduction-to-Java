package com.onto.javacourse.stopcounterthread;

/**
 * A simple interface for listening to the end of the counter.
 */
public interface CounterListener {
  /**
   * Called when the counter finishes.
   */
  void onCounterFinished();
}
