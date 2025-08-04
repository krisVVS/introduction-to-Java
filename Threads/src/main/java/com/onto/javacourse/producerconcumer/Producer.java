package com.onto.javacourse.producerconcumer;

/**
 * A producer that adds goods to the warehouse.
 */
public class Producer implements Runnable {

  private final Warehouse warehouse;
  private final int amount;
  private final int cycles;

  /**
   * Constructs a producer with the given warehouse, production amount, and cycles.
   *
   * @param warehouse the warehouse to produce into
   * @param amount    the number of goods to produce each time
   * @param cycles    the number of production cycles to run
   */
  public Producer(Warehouse warehouse, int amount, int cycles) {
    this.warehouse = warehouse;
    this.amount = amount;
    this.cycles = cycles;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < cycles; i++) {
        warehouse.produce(amount);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
