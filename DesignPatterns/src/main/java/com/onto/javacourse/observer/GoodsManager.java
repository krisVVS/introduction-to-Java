package com.onto.javacourse.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Subject interface and manages the list of goods.
 * It notifies observers when goods are added or sold.
 */
public class GoodsManager implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private List<String> goods = new ArrayList<>();

  /**
   * Registers an observer to be notified of changes in the goods list.
   *
   * @param observer the observer to be registered
   */
  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * Removes an observer from the list of observers.
   *
   * @param observer the observer to be removed
   */
  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all registered observers of a change in the goods list.
   *
   * @param eventType the type of event (either "added" or "sold")
   * @param goodName the name of the good
   */
  @Override
  public void notifyObservers(String eventType, String goodName) {
    for (Observer observer : observers) {
      observer.update(eventType, goodName);
    }
  }

  /**
   * Adds a new good to the list and notifies observers.
   *
   * @param goodName the name of the good to be added
   */
  public void addGood(String goodName) {
    goods.add(goodName);
    notifyObservers("added", goodName);
  }

  /**
   * Removes a good from the list and notifies observers.
   *
   * @param goodName the name of the good to be sold
   */
  public void sellGood(String goodName) {
    if (goods.remove(goodName)) {
      notifyObservers("sold", goodName);
    }
  }
}
