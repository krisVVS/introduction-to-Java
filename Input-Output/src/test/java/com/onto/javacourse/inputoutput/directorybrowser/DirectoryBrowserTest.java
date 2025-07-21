package com.onto.javacourse.inputoutput.directorybrowser;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryBrowserTest {

  @Test
  public void testListContentWithFile() throws IOException {
    String testFilePath = "src/test/resources/testfile.txt";
    Path testFile = Paths.get(testFilePath);

    Files.createDirectories(testFile.getParent());

    Files.createFile(testFile);

    try {
      List<String> content = DirectoryBrowser.listContent(testFilePath);

      assertNotNull(content);
      assertEquals(1, content.size());
      assertTrue(content.get(0).contains("File: testfile.txt"));
    } finally {
      Files.deleteIfExists(testFile);
    }
  }

  @Test
  public void testListContentWithDirectory() throws IOException {
    String testDirPath = "src/test/resources/testdir";
    Files.createDirectories(Paths.get(testDirPath));
    Files.createFile(Paths.get(testDirPath + "/file1.txt"));
    Files.createDirectory(Paths.get(testDirPath + "/subdir"));
    List<String> content = DirectoryBrowser.listContent(testDirPath);

    assertNotNull(content);
    assertTrue(content.size() > 0);
    assertTrue(content.stream().anyMatch(s -> s.contains("File: file1.txt")));
    assertTrue(content.stream().anyMatch(s -> s.contains("Directory: subdir")));
    Files.delete(Paths.get(testDirPath + "/file1.txt"));
    Files.delete(Paths.get(testDirPath + "/subdir"));
    Files.delete(Paths.get(testDirPath));
  }

  @Test
  public void testListContentWithInvalidPath() {
    String invalidPath = "src/test/resources/invalidpath";
    try {
      DirectoryBrowser.listContent(invalidPath);
      fail("Expected IOException for invalid path");
    } catch (IOException e) {
      assertTrue(e.getMessage().contains("Invalid file or directory path"));
    }
  }
}
