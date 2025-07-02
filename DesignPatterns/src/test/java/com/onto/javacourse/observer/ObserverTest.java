package com.onto.javacourse.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

  private GoodsManager goodsManager;
  private AvailableGoodsStatistics availableStats;
  private SoldGoodsStatistics soldStats;

  @BeforeEach
  void setUp() {
    goodsManager = new GoodsManager();
    availableStats = new AvailableGoodsStatistics();
    soldStats = new SoldGoodsStatistics();

    // Register observers
    goodsManager.registerObserver(availableStats);
    goodsManager.registerObserver(soldStats);
  }

  @Test
  void testAddGood() {
    goodsManager.addGood("Laptop");

    // Ensure "Laptop" is in the available goods statistics
    availableStats.printAvailableGoods();
    assertTrue(availableStats.getAvailableGoods().contains("Laptop"), "Laptop should be in available goods.");
  }

  @Test
  void testSellGood() {
    goodsManager.addGood("Laptop");
    goodsManager.sellGood("Laptop");

    // Ensure "Laptop" is no longer in the available goods
    assertFalse(availableStats.getAvailableGoods().contains("Laptop"), "Laptop should be removed from available goods.");

    // Ensure "Laptop" is in the sold goods
    assertTrue(soldStats.getSoldGoods().contains("Laptop"), "Laptop should be in sold goods.");
  }

  @Test
  void testMultipleGoods() {
    goodsManager.addGood("Laptop");
    goodsManager.addGood("Phone");
    goodsManager.addGood("Tablet");

    // Ensure all goods are added to available goods
    assertTrue(availableStats.getAvailableGoods().contains("Laptop"));
    assertTrue(availableStats.getAvailableGoods().contains("Phone"));
    assertTrue(availableStats.getAvailableGoods().contains("Tablet"));

    goodsManager.sellGood("Phone");

    // Ensure "Phone" is removed from available goods and added to sold goods
    assertFalse(availableStats.getAvailableGoods().contains("Phone"));
    assertTrue(soldStats.getSoldGoods().contains("Phone"));
  }
}
