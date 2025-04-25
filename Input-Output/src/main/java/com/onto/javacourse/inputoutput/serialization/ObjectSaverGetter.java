package com.onto.javacourse.inputoutput.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Handles the serialization and deserialization of UserDefinedObject instances.
 */
public class ObjectSaverGetter {

  /**
   * Saves a UserDefinedObject to a file.
   *
   * @param path the path to the file where the object should be saved
   * @param o    the UserDefinedObject to be saved
   * @throws IOException if an I/O error occurs while saving the object
   */
  public void saveObject(String path, UserDefinedObject o) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
      out.writeObject(o);
    } catch (IOException e) {
      throw new IOException("Unable to save object", e);
    }
  }

  /**
   * Reads a UserDefinedObject from a file.
   *
   * @param path the path to the file from which the object should be read
   * @return the UserDefinedObject read from the file
   * @throws IOException if an I/O error occurs while reading the object
   */
  public UserDefinedObject getObject(String path) throws IOException {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
      return (UserDefinedObject) in.readObject();
    } catch (ClassNotFoundException e) {
      throw new IOException("Unable to read the object from file.", e);
    }
  }
}
