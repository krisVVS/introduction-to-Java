package com.onto.javacourse.producerconcumer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

  @Test
  void testProducerBlocksWhenWarehouseFull() throws InterruptedException {
    Warehouse warehouse = new Warehouse(5);
    warehouse.produce(5);

    Thread producer = new Thread(() -> {
      try {
        warehouse.produce(1);
      } catch (InterruptedException ignored) {}
    });

    producer.start();
    Thread.sleep(300);

    assertTrue(producer.isAlive());
    warehouse.consume(5);
    Thread.sleep(300);
    assertFalse(producer.isAlive());
  }

  @Test
  void testConsumerBlocksWhenWarehouseEmpty() throws InterruptedException {
    Warehouse warehouse = new Warehouse(5);

    Thread consumer = new Thread(() -> {
      try {
        warehouse.consume(1);
      } catch (InterruptedException ignored) {}
    });

    consumer.start();
    Thread.sleep(300);

    assertTrue(consumer.isAlive());
    warehouse.produce(1);
    Thread.sleep(300);
    assertFalse(consumer.isAlive());
  }

  @Test
  void testProducerAndConsumerWorkTogether() throws InterruptedException {
    Warehouse warehouse = new Warehouse(10);

    Thread producer = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          warehouse.produce(2);
        }
      } catch (InterruptedException ignored) {}
    });

    Thread consumer = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          warehouse.consume(2);
        }
      } catch (InterruptedException ignored) {}
    });

    producer.start();
    consumer.start();

    producer.join(3000);
    consumer.join(3000);

    assertFalse(producer.isAlive());
    assertFalse(consumer.isAlive());
  }

  @Test
  void testProducerIncreasesStock() throws InterruptedException {
    Warehouse warehouse = new Warehouse(10);
    Thread producer = new Thread(new Producer(warehouse, 2, 3));

    producer.start();
    producer.join(3000);

    assertFalse(producer.isAlive());
    assertTrue(warehouse.getStock() >= 6);
  }

  @Test
  void testConsumerDecreasesStock() throws InterruptedException {
    Warehouse warehouse = new Warehouse(10);
    warehouse.produce(9);

    Thread consumer = new Thread(new Consumer(warehouse, 3, 2));

    consumer.start();
    consumer.join(3000);

    assertFalse(consumer.isAlive());
    assertTrue(warehouse.getStock() <= 3);
  }

  @Test
  void testProducersAndConsumersTogether() throws InterruptedException {
    Warehouse warehouse = new Warehouse(20);

    Thread producer1 = new Thread(new Producer(warehouse, 4, 5));
    Thread producer2 = new Thread(new Producer(warehouse, 2, 5));
    Thread consumer1 = new Thread(new Consumer(warehouse, 3, 5));
    Thread consumer2 = new Thread(new Consumer(warehouse, 2, 5));

    producer1.start();
    producer2.start();
    consumer1.start();
    consumer2.start();

    producer1.join(5000);
    producer2.join(5000);
    consumer1.join(5000);
    consumer2.join(5000);

    assertFalse(producer1.isAlive());
    assertFalse(producer2.isAlive());
    assertFalse(consumer1.isAlive());
    assertFalse(consumer2.isAlive());

    int stock = warehouse.getStock();
    assertTrue(stock >= 0 && stock <= 20);
  }
}
