package com.onto.javacourse.ibanreplacer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReplacerTest {

  @Test
  void testReplaceWithValidBulgarianIBAN() {
    Replacer replacer = new Replacer();
    String input = "<iban>BG80 BNBG 9661 1020 1234 5678</iban>";
    String expected = "<iban>BG80 BNBG**** 5678</iban>";
    assertEquals(expected, replacer.replace(input));
  }

  @Test
  void testReplaceWithNoBulgarianIBAN() {
    Replacer replacer = new Replacer();
    String input = "<iban>GB29 NWBK 6016 1331 9268 19</iban>";
    assertEquals(input, replacer.replace(input));
  }

  @Test
  void testReplaceWithEmptyString() {
    Replacer replacer = new Replacer();
    String input = "";
    assertEquals(input, replacer.replace(input));
  }

  @Test
  void testReplaceWithNullInput() {
    Replacer replacer = new Replacer();
    String input = null;
    assertNull(replacer.replace(input));
  }

  @Test
  void testReplaceWithMixedIBANs() {
    Replacer replacer = new Replacer();
    String input = "<iban>BG80 BNBG 9661 1020 1234 5678</iban>\n<iban>GB29 NWBK 6016 1331 9268 19</iban>";
    String expected = "<iban>BG80 BNBG**** 5678</iban>\n<iban>GB29 NWBK 6016 1331 9268 19</iban>";
    assertEquals(expected, replacer.replace(input));
  }
}