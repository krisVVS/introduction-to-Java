package com.onto.javacourse.objectinformationdisplayer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Inspects and logs details about the class of the given object, including its fields and methods.
 */
public class ObjectInformationDisplayer {

  private static final Logger LOGGER = LoggerFactory.getLogger(ObjectInformationDisplayer.class);

  /**
   * Retrieves and returns details about the class of the provided object.
   * Logs information about the class, including fields and methods.
   *
   * @param instance The object whose class details are to be retrieved.
   * @return A ClassDetails object containing the class name, fields, and methods.
   */
  public static ClassDetails returnClassDetails(Object instance) {
    if (instance == null) {
      LOGGER.warn("Provided instance is null. Cannot display class details.");
      return null;
    }

    Class<?> instanceClass = instance.getClass();
    ClassDetails classDetails = new ClassDetails(instanceClass.getName());

    getFields(instance, instanceClass, classDetails);
    getMethods(instanceClass, classDetails);

    return classDetails;
  }

  /**
   * Retrieves the fields of the given class and adds their details
   * to the provided ClassDetails object.
   *
   * @param instance The object whose fields are to be retrieved.
   * @param instanceClass The class of the provided object.
   * @param classDetails The object to which the field details are added.
   */
  private static void getFields(
      Object instance, Class<?> instanceClass, ClassDetails classDetails
  ) {
    Field[] declaredFields = instanceClass.getDeclaredFields();
    for (Field field : declaredFields) {
      field.setAccessible(true);
      try {
        String fieldValue = String.valueOf(field.get(instance));
        classDetails.addField(new ClassDetails.FieldDetail(
            Modifier.toString(field.getModifiers()),
            field.getType().getSimpleName(),
            field.getName(),
            fieldValue));
      } catch (IllegalAccessException e) {
        LOGGER.warn("{} {} = [inaccessible]",
            Modifier.toString(field.getModifiers()),
            field.getName());
      }
    }
  }

  /**
   * Retrieves the methods of the given class and adds their details
   * to the provided ClassDetails object.
   *
   * @param instanceClass The class whose methods are to be retrieved.
   * @param classDetails The object to which the method details are added.
   */
  private static void getMethods(Class<?> instanceClass, ClassDetails classDetails) {
    Method[] declaredMethods = instanceClass.getDeclaredMethods();
    for (Method method : declaredMethods) {
      method.setAccessible(true);
      String parameterTypes = getMethodParameterTypes(method);
      classDetails.addMethod(new ClassDetails.MethodDetail(
          Modifier.toString(method.getModifiers()),
          method.getReturnType().getSimpleName(),
          method.getName(),
          parameterTypes));
    }
  }

  /**
   * Utility method to retrieve and format the parameter types of a given method.
   *
   * @param method The method whose parameter types are to be retrieved.
   * @return A string representing the parameter types of the method.
   */
  private static String getMethodParameterTypes(Method method) {
    Class<?>[] parameterTypes = method.getParameterTypes();
    StringBuilder parameters = new StringBuilder();

    for (Class<?> param : parameterTypes) {
      if (parameters.length() > 0) {
        parameters.append(", ");
      }
      parameters.append(param.getSimpleName());
    }

    return parameters.toString();
  }
}
