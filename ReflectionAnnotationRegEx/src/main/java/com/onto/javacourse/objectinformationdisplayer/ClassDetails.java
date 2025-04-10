package com.onto.javacourse.objectinformationdisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the details of a class, including its name, fields, and methods.
 */
public class ClassDetails {
  private String className;
  private List<FieldDetail> fields;
  private List<MethodDetail> methods;

  /**
   * Constructs a new ClassDetails object with the specified class name.
   *
   * @param className The name of the class.
   */
  public ClassDetails(String className) {
    this.className = className;
    this.fields = new ArrayList<>();
    this.methods = new ArrayList<>();
  }

  /**
   * Adds a field detail to the list of fields in this ClassDetails.
   *
   * @param fieldDetail The field detail to be added.
   */
  public void addField(FieldDetail fieldDetail) {
    fields.add(fieldDetail);
  }

  /**
   * Adds a method detail to the list of methods in this ClassDetails.
   *
   * @param methodDetail The method detail to be added.
   */
  public void addMethod(MethodDetail methodDetail) {
    methods.add(methodDetail);
  }

  /**
   * Retrieves the class name of this ClassDetails.
   *
   * @return The name of the class.
   */
  public String getClassName() {
    return className;
  }

  /**
   * Retrieves the list of field details in this ClassDetails.
   *
   * @return A list of FieldDetail objects.
   */
  public List<FieldDetail> getFields() {
    return fields;
  }

  /**
   * Retrieves the list of method details in this ClassDetails.
   *
   * @return A list of MethodDetail objects.
   */
  public List<MethodDetail> getMethods() {
    return methods;
  }

  /**
   * Represents the details of a field in a class.
   */
  public static class FieldDetail {
    private String modifier;
    private String type;
    private String name;
    private String value;

    /**
     * Constructs a new FieldDetail object with the specified details.
     *
     * @param modifier The modifier of the field (e.g., public, private).
     * @param type The type of the field.
     * @param name The name of the field.
     * @param value The value of the field.
     */
    public FieldDetail(String modifier, String type, String name, String value) {
      this.modifier = modifier;
      this.type = type;
      this.name = name;
      this.value = value;
    }

    /**
     * Retrieves the modifier of this field.
     *
     * @return The modifier of the field.
     */
    public String getModifier() {
      return modifier;
    }

    /**
     * Retrieves the type of this field.
     *
     * @return The type of the field.
     */
    public String getType() {
      return type;
    }

    /**
     * Retrieves the name of this field.
     *
     * @return The name of the field.
     */
    public String getName() {
      return name;
    }

    /**
     * Retrieves the value of this field.
     *
     * @return The value of the field.
     */
    public String getValue() {
      return value;
    }
  }

  /**
   * Represents the details of a method in a class.
   */
  public static class MethodDetail {
    private String modifier;
    private String returnType;
    private String name;
    private String parameters;

    /**
     * Constructs a new MethodDetail object with the specified details.
     *
     * @param modifier The modifier of the method (e.g., public, private).
     * @param returnType The return type of the method.
     * @param name The name of the method.
     * @param parameters The parameters of the method.
     */
    public MethodDetail(String modifier, String returnType, String name, String parameters) {
      this.modifier = modifier;
      this.returnType = returnType;
      this.name = name;
      this.parameters = parameters;
    }

    /**
     * Retrieves the modifier of this method.
     *
     * @return The modifier of the method.
     */
    public String getModifier() {
      return modifier;
    }

    /**
     * Retrieves the return type of this method.
     *
     * @return The return type of the method.
     */
    public String getReturnType() {
      return returnType;
    }

    /**
     * Retrieves the name of this method.
     *
     * @return The name of the method.
     */
    public String getName() {
      return name;
    }

    /**
     * Retrieves the parameters of this method.
     *
     * @return A string representing the parameters of the method.
     */
    public String getParameters() {
      return parameters;
    }
  }
}
