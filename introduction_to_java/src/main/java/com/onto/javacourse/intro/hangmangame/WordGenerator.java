package com.onto.javacourse.intro.hangmangame;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The WordGenerator class is responsible for loading a list of words from a resource file and
 * providing a random word from that list.
 */
public class WordGenerator {
  public static List<String> words = new ArrayList<>();
  public static ClassLoader classLoader = WordGenerator.class.getClassLoader();
  public static InputStream inputStream = classLoader.getResourceAsStream("words");
  public static Scanner scanner = new Scanner(inputStream);

  /**
   * Loads words from the resource file and returns a random word from the list.
   *
   * @return a random word from the list of words loaded from the resource file
   */
  public static String randomWords() {
    while (scanner.hasNextLine()) {
      words.add(scanner.nextLine());
    }
    Random rand = new Random();
    String word = words.get(rand.nextInt(words.size()));
    return word;
  }
}
