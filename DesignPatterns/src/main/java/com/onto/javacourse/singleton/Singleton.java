package com.onto.javacourse.singleton;

/**
 * Singleton class to ensure only one instance is created.
 */
public class Singleton {

  private static Singleton instance;

  /**
   * Private constructor to prevent instantiation.
   */
  private Singleton() {
    System.out.println("Singleton created");
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
