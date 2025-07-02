package com.onto.javacourse.observer;

/**
 * The Observer interface is implemented by classes that need to receive updates
 * when the state of a subject (like goods) changes.
 */
public interface Observer {

  /**
   * Called to update the observer with an event.
   *
   * @param eventType the type of event (e.g., "added" or "sold")
   * @param goodName the name of the good related to the event
   */
  void update(String eventType, String goodName);
}
