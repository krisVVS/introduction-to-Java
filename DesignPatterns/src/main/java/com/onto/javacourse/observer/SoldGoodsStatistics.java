package com.onto.javacourse.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class implements the Observer interface and maintains a list of sold goods.
 */
public class SoldGoodsStatistics implements Observer {
  Logger logger = Logger.getLogger(SoldGoodsStatistics.class.getName());
  private List<String> soldGoods = new ArrayList<>();

  /**
   * Updates the list of sold goods when a good is sold.
   *
   * @param eventType the type of event (only "sold" is relevant for this class)
   * @param goodName the name of the good that has been sold
   */
  @Override
  public void update(String eventType, String goodName) {
    if (eventType.equals("sold")) {
      soldGoods.add(goodName);
    }
  }

  /**
   * Returns the list of sold goods.
   *
   * @return the list of sold goods
   */
  public List<String> getSoldGoods() {
    return soldGoods;
  }

  /**
   * Prints the list of sold goods.
   */
  public void printSoldGoods() {
    logger.info("Sold goods: " + soldGoods);
  }
}
