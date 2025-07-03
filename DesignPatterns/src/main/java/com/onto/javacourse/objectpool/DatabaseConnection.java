package com.onto.javacourse.objectpool;

import java.util.logging.Logger;

/**
 * Represents a database connection that can be used for database operations.
 */
public class DatabaseConnection {
  Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

  /**
   * Constructs a new DatabaseConnection instance.
   * Prints a message when a new instance is created.
   */
  public DatabaseConnection() {
    LOGGER.info("Database connection created");
  }
}
