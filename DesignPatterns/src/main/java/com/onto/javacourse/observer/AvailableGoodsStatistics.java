package com.onto.javacourse.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class implements the Observer interface and maintains a list of available goods.
 */
public class AvailableGoodsStatistics implements Observer {
  Logger log = Logger.getLogger(this.getClass().getName());
  private List<String> availableGoods = new ArrayList<>();

  /**
   * Updates the list of available goods based on the event type and good name.
   *
   * @param eventType the type of event (either "added" or "sold")
   * @param goodName the name of the good
   */
  @Override
  public void update(String eventType, String goodName) {
    if (eventType.equals("added")) {
      availableGoods.add(goodName);
    } else if (eventType.equals("sold")) {
      availableGoods.remove(goodName);
    }
  }

  /**
   * Returns the list of available goods.
   *
   * @return the list of available goods
   */
  public List<String> getAvailableGoods() {
    return availableGoods;
  }

  /**
   * Prints the list of available goods.
   */
  public void printAvailableGoods() {
    log.info("Available goods: " + availableGoods);
  }
}
