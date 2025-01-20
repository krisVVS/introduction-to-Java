package com.onto.javacourse.displayprivate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Utility class to display private fields and methods of a given object using reflection.
 */
public class DisplayPrivate {
  private static final Logger LOGGER = LoggerFactory.getLogger(DisplayPrivate.class);

  /**
   * Displays the private fields and methods of the given object.
   *
   * @param instance The object whose private fields and methods are to be displayed.
   */
  public static void displayPrivate(Object instance) {
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
      if (Modifier.isPrivate(field.getModifiers())) {
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
          throw new RuntimeException(e);
        }
      }
    }
    LOGGER.info("");
    LOGGER.info("Methods:");
    Method[] declaredMethods = instanceClass.getDeclaredMethods();
    for (Method method : declaredMethods) {
      method.setAccessible(true);
      if (Modifier.isPrivate(method.getModifiers())) {
        try {
          if (method.getParameterCount() == 0) {
            Object result = method.invoke(instance);
            LOGGER.info("{} {} {}(): {}",
                Modifier.toString(method.getModifiers()),
                method.getReturnType().getSimpleName(),
                method.getName(),
                result);
          } else {
            LOGGER.info("{} {} {}({}): [requires parameters]",
                Modifier.toString(method.getModifiers()),
                method.getReturnType().getSimpleName(),
                method.getName(),
                getMethodParameterTypes(method));
          }
        } catch (IllegalAccessException e) {
          LOGGER.warn("Failed to invoke method '{}': {}", method.getName(), e.getMessage());
          throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
          LOGGER.warn("Failed to invoke method '{}': {}", method.getName(), e.getMessage());
          throw new RuntimeException(e);
        }
      }
    }
  }

  /**
   * Retrieves a comma-separated string representation of parameter types for a given method.
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
