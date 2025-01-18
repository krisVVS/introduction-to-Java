package com.onto.javacourse.displayer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to display details about the fields and methods of a given object's class.
 * It uses reflection to retrieve information and logs it using SLF4J.
 */
public class Displayer {
  private static final Logger LOGGER = LoggerFactory.getLogger(Displayer.class);

  /**
   * Logs details about the class of the given object, including its fields and methods.
   *
   * @param instance The object whose class details are to be logged.
   */
  public static void returnClassDetails(Object instance) {
    if (instance == null) {
      LOGGER.warn("Provided instance is null. Cannot display class details.");
      return;
    }
    Class<?> instanceClass = instance.getClass();
    LOGGER.info("Class: {}", instanceClass.getName());
    LOGGER.info("");
    LOGGER.info("Fields:");
    Field[] declaredFields = instanceClass.getDeclaredFields();
    for (Field field : declaredFields) {
      field.setAccessible(true);
      try {
        LOGGER.info("{} {} {} = {}",
            Modifier.toString(field.getModifiers()),
            field.getType().getSimpleName(),
            field.getName(),
            field.get(instance));
      } catch (IllegalAccessException e) {
        LOGGER.warn("{} {} = [inaccessible]",
            Modifier.toString(field.getModifiers()),
            field.getName());
      }
    }
    LOGGER.info("");
    LOGGER.info("Methods:");
    Method[] declaredMethods = instanceClass.getDeclaredMethods();
    for (Method method : declaredMethods) {
      method.setAccessible(true);
      LOGGER.info("{} {} {}({})",
          Modifier.toString(method.getModifiers()),
          method.getReturnType().getSimpleName(),
          method.getName(),
          getMethodParameterTypes(method));
    }
  }

  /**
   * Retrieves a comma-separated string of parameter types for a given method.
   *
   * @param method The method whose parameter types are to be retrieved.
   * @return A string representation of the method's parameter types.
   */
  private static String getMethodParameterTypes(Method method) {
    Class<?>[] parameterTypes = method.getParameterTypes();
    StringBuilder parameters = new StringBuilder();
    for (int i = 0; i < parameterTypes.length; i++) {
      if (i > 0) {
        parameters.append(", ");
      }
      parameters.append(parameterTypes[i].getSimpleName());
    }
    return parameters.toString();
  }
}
