package com.onto.javacourse.collections.hashdice;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Simulates the rolling of two six-sided dice N times and records
 * the throw numbers for each unique combination.
 */
public class HashDice {

  private static final Random rand = new Random();

  /**
   * Generates a string representing a sorted dice combination (e.g., "2, 5").
   *
   * @return a string in the format "x, y" where x <= y and both are from 1 to 6
   */
  private static String generateThrow() {
    int dice1 = rand.nextInt(6) + 1;
    int dice2 = rand.nextInt(6) + 1;

    int first = Math.min(dice1, dice2);
    int second = Math.max(dice1, dice2);

    return first + ", " + second;
  }

  /**
   * Rolls two dice N times and maps each unique combination to the list
   * of throw indices where it appeared. The result is printed and returned.
   *
   * @param n the number of dice throws to simulate
   * @return a map of dice combinations to their corresponding throw indices
   */
  public static Map<String, ArrayList<Integer>> throwingDice(int n) {
    Map<String, ArrayList<Integer>> map = new TreeMap<>();
    for (int i = 1; i <= n; i++) {
      String key = generateThrow();
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
    }
    for (String combo : map.keySet()) {
      System.out.println("Combination: " + combo + " -> Throws: " + map.get(combo));
    }
    return map;
  }
}
