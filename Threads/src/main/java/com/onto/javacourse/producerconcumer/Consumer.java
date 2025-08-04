package com.onto.javacourse.producerconcumer;

/**
 * A consumer (trader) that removes goods from the warehouse.
 */
public class Consumer implements Runnable {

  private final Warehouse warehouse;
  private final int amount;
  private final int cycles;

  /**
   * Constructs a consumer with the given warehouse, consumption amount, and cycles.
   *
   * @param warehouse the warehouse to consume from
   * @param amount    the number of goods to consume each time
   * @param cycles    the number of consumption cycles to run
   */
  public Consumer(Warehouse warehouse, int amount, int cycles) {
    this.warehouse = warehouse;
    this.amount = amount;
    this.cycles = cycles;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < cycles; i++) {
        warehouse.consume(amount);
        Thread.sleep(700);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
