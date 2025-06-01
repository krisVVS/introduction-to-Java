package com.onto.javacourse.collections.hashdice;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class HashDiceTest {

  @Test
  void testThrowingDiceTotalThrows() {
    int N = 50;
    Map<String, ArrayList<Integer>> result = HashDice.throwingDice(N);

    int totalThrowsTracked = result.values().stream().mapToInt(ArrayList::size).sum();
    assertEquals(N, totalThrowsTracked);
  }

  @Test
  void testCombinationFormatAndRange() {
    int N = 100;
    Map<String, ArrayList<Integer>> result = HashDice.throwingDice(N);

    for (String combo : result.keySet()) {
      String[] parts = combo.split(", ");
      assertEquals(2, parts.length);

      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);

      assertTrue(a >= 1 && a <= 6);
      assertTrue(b >= 1 && b <= 6);
      assertTrue(a <= b);
    }
  }

  @Test
  void testEachCombinationHasThrows() {
    int N = 30;
    Map<String, ArrayList<Integer>> result = HashDice.throwingDice(N);

    for (Map.Entry<String, ArrayList<Integer>> entry : result.entrySet()) {
      assertFalse(entry.getValue().isEmpty());
    }
  }
}
