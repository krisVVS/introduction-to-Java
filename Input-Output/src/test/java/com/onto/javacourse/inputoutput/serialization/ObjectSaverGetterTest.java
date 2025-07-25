package com.onto.javacourse.inputoutput.serialization;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ObjectSaverGetterTest {
  private static final String TEST_FILE = "test_user.dat";
  private ObjectSaverGetter objectSaverGetter;

  @BeforeEach
  void setUp() {
    objectSaverGetter = new ObjectSaverGetter();
  }

  @Test
  void testSaveAndGetObject() throws IOException {
    UserDefinedObject originalUser = new UserDefinedObject(1, "Alice", 1500.75);

    objectSaverGetter.saveObject(TEST_FILE, originalUser);

    UserDefinedObject retrievedUser = objectSaverGetter.getObject(TEST_FILE);

    assertNotNull(retrievedUser);
    assertEquals(originalUser.getId(), retrievedUser.getId());
    assertEquals(originalUser.getName(), retrievedUser.getName());
    assertEquals(originalUser.getBalance(), retrievedUser.getBalance());
  }

  @Test
  void testGetObjectFromNonExistingFile() {
    assertThrows(IOException.class, () -> objectSaverGetter.getObject("non_existing_file.dat"));
  }

  @Test
  void testSaveObjectIOException() throws IOException {
    UserDefinedObject user = new UserDefinedObject(2, "Bob", 2500.50);

    File file = new File(TEST_FILE);

    file.createNewFile();
    file.setWritable(false);

    assertThrows(IOException.class, () -> objectSaverGetter.saveObject(TEST_FILE, user));

    file.setWritable(true);
    file.delete();
  }

  @AfterEach
  void tearDown() {
    File file = new File(TEST_FILE);
    if (file.exists()) {
      file.delete();
    }
  }
}
