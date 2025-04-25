package com.onto.javacourse.inputoutput.serialization;

import java.io.Serializable;

/**
 * Represents a user-defined object for serialization, containing
 * basic user information such as id, name, and balance.
 */
public class UserDefinedObject implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private double balance;

  /**
   * Constructs a UserDefinedObject with the specified id, name, and balance.
   *
   * @param id the id of the user
   * @param name the name of the user
   * @param balance the balance associated with the user
   */
  public UserDefinedObject(int id, String name, double balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }

  /**
   * Returns the id of the user.
   *
   * @return the id of the user
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id of the user.
   *
   * @param id the new id of the user
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Returns the name of the user.
   *
   * @return the name of the user
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the user.
   *
   * @param name the new name of the user
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the balance of the user.
   *
   * @return the balance of the user
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Sets the balance of the user.
   *
   * @param balance the new balance of the user
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Returns a string representation of the UserDefinedObject.
   *
   * @return a string representation of the UserDefinedObject
   */
  @Override
  public String toString() {
    return "UserDefinedObject{id=" + id + ", name='" + name + "', balance=" + balance + "}";
  }
}
