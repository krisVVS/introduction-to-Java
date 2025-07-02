package com.onto.javacourse.observer;

/**
 * The Subject interface is implemented by classes that maintain a list of observers
 * and notify them of any changes to the state of the subject.
 */
public interface Subject {

  /**
   * Registers an observer to be notified of changes in the subject's state.
   *
   * @param observer the observer to be registered
   */
  void registerObserver(Observer observer);

  /**
   * Removes an observer from the list of registered observers.
   *
   * @param observer the observer to be removed
   */
  void removeObserver(Observer observer);

  /**
   * Notifies all registered observers of a change in the subject's state.
   *
   * @param eventType the type of event (e.g., "added" or "sold")
   * @param goodName the name of the good related to the event
   */
  void notifyObservers(String eventType, String goodName);
}
