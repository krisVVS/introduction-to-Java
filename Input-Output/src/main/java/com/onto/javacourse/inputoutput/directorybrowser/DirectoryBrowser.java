package com.onto.javacourse.inputoutput.directorybrowser;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The DirectoryBrowser class provides a method to list the contents of a file or directory.
 * It checks whether the provided path is a file or directory and returns the appropriate content.
 */
public class DirectoryBrowser {
  private static final Logger LOGGER = LoggerFactory.getLogger(DirectoryBrowser.class);

  /**
   * Lists the content of the specified path.
   * If the path is a file, it logs and returns a message indicating that it's a file.
   * If the path is a directory, it logs and returns a list of files and directories inside it.
   * If the path is neither a file nor a directory, it throws an IOException with an error message.
   *
   * @param path The path to the file or directory to be checked.
   * @return A list of strings representing the content of the directory
   * @throws IOException If an I/O error occurs: invalid path or error reading the directory.
   */
  public static List<String> listContent(String path) throws IOException {
    Path p1 = Paths.get(path);
    List<String> contentList = new ArrayList<>();

    if (Files.isRegularFile(p1)) {
      LOGGER.info("The path " + p1 + " is a file: " + p1.getFileName());
      contentList.add("File: " + p1.getFileName());
    } else if (Files.isDirectory(p1)) {
      LOGGER.info("The path " + p1 + " is a directory.");
      LOGGER.info("Listing contents:");
      try (DirectoryStream<Path> stream = Files.newDirectoryStream(p1)) {
        for (Path file : stream) {
          if (Files.isRegularFile(file)) {
            LOGGER.info("File: " + file.getFileName());
            contentList.add("File: " + file.getFileName());
          } else if (Files.isDirectory(file)) {
            LOGGER.info("Directory: " + file.getFileName());
            contentList.add("Directory: " + file.getFileName());
          }
        }
      } catch (IOException | DirectoryIteratorException e) {
        LOGGER.error("Error reading the directory: " + e);
        throw new IOException("Error reading the directory: " + e);
      }
    } else {
      LOGGER.error("The path " + path + " does not exist or is not a valid file or directory.");
      contentList.add("Error: Invalid file or directory path.");
      throw new IOException("Invalid file or directory path.");
    }

    return contentList;
  }
}
