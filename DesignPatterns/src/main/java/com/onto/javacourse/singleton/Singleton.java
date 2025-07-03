package com.onto.javacourse.singleton;

import java.util.logging.Logger;

/**
 * Singleton class to ensure only one instance is created.
 */
public class Singleton {
  Logger LOGGER = Logger.getLogger("com.onto.javacourse.singleton");
  private static Singleton instance;

  /**
   * Private constructor to prevent instantiation.
   */
  private Singleton() {
    LOGGER.info("Singleton created");
  }

  /**
   * Returns the single instance of the Singleton class.
   *
   * @return the Singleton instance
   */
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
