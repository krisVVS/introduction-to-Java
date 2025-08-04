package com.onto.javacourse.producerconcumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A warehouse that supports multiple producers and consumers.
 * Producers wait if the warehouse is full,
 * consumers wait if the warehouse is empty.
 */
public class Warehouse {

  private static final Logger LOGGER = LoggerFactory.getLogger(Warehouse.class);

  private final int capacity;
  private int stock = 0;

  /**
   * Constructs a warehouse with a given capacity.
   *
   * @param capacity maximum goods the warehouse can hold
   */
  public Warehouse(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Produces goods and adds them to the warehouse.
   * Waits if there is not enough space.
   *
   * @param amount number of goods to produce
   * @throws InterruptedException if interrupted while waiting
   */
  public synchronized void produce(int amount) throws InterruptedException {
    while (stock + amount > capacity) {
      LOGGER.info("Warehouse full. Producer waits.");
      wait();
    }
    stock += amount;
    LOGGER.info("Produced {} items. Stock = {}", amount, stock);
    notifyAll();
  }

  /**
   * Consumes goods from the warehouse.
   * Waits if there are not enough goods.
   *
   * @param amount number of goods to consume
   * @throws InterruptedException if interrupted while waiting
   */
  public synchronized void consume(int amount) throws InterruptedException {
    while (stock < amount) {
      LOGGER.info("Warehouse empty. Consumer waits.");
      wait();
    }
    stock -= amount;
    LOGGER.info("Consumed {} items. Stock = {}", amount, stock);
    notifyAll();
  }

  /**
   * Returns the current stock in the warehouse.
   *
   * @return current number of goods in stock
   */
  public synchronized int getStock() {
    return stock;
  }
}
