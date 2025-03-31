package com.onto.javacourse.displaybyname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A utility class for displaying information about a class by its fully qualified name.
 * The class provides details such as the class name, its parent class,
 * and the interfaces it implements.
 *
 * <p>This class uses SLF4J for logging.</p>
 */
public class DisplayerByName {

  private static final Logger LOGGER = LoggerFactory.getLogger(DisplayerByName.class);

  /**
   * Displays information about a class based on its fully qualified name.
   *
   * <p>The method logs the following details:
   * <ul>
   *   <li>Class name</li>
   *   <li>Parent class name (if any)</li>
   *   <li>Names of interfaces implemented by the class</li>
   * </ul>
   * If the class name is invalid or not found, an error is logged
   * and a {@link RuntimeException} is thrown.
   *
   * @param name the fully qualified name of the class
   * @throws RuntimeException if the class cannot be found
   */
  public static void displayerByName(String name) {
    if (name == null || name.trim().isEmpty()) {
      LOGGER.error("Class name cannot be null or empty.");
      throw new IllegalArgumentException("Class name cannot be null or empty.");
    }

    try {
      Class<?> className = Class.forName(name);

      LOGGER.info("Class Name: {}", className.getName());

      Class<?> parentClass = className.getSuperclass();
      if (parentClass != null) {
        LOGGER.info("Parent Class: {}", parentClass.getName());
      } else {
        LOGGER.info("Parent Class: None");
      }

      Class<?>[] interfaces = className.getInterfaces();
      LOGGER.info("Implemented Interfaces:");
      for (Class<?> iface : interfaces) {
        LOGGER.info("  {}", iface.getName());
      }

    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("Class not found: " + name, e);
    }
  }
}
