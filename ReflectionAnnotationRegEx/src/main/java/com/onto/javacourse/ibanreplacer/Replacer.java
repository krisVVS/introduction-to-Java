package com.onto.javacourse.ibanreplacer;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides functionality to partially mask Bulgarian IBANs in a given string.
 */
public class Replacer {

  private static final String bulgarianIBANPattern =
      "(?<=<iban>BG\\d{2} [A-Z]{4}) (\\d{4} \\d{4} \\d{4})(?=.*\\d{4}</iban>)";
  private static final Logger LOGGER = Logger.getLogger(Replacer.class.getName());

  /**
   * Replaces the middle part of Bulgarian IBANs with "****" while keeping other parts visible.
   *
   * @param input the input string containing IBANs to be processed.
   * @return the modified string with Bulgarian IBANs partially masked, or the original string
   if no changes are made.
   */
  public String replace(String input) {
    if (input == null || input.length() == 0) {
      LOGGER.warning("Input is null or empty");
      return input;
    }
    Pattern pattern = Pattern.compile(bulgarianIBANPattern);
    Matcher matcher = pattern.matcher(input);
    String maskedOutput = matcher.replaceAll("****");
    if (!input.equals(maskedOutput)) {
      LOGGER.info("Replacements made in the input string.");
    } else {
      LOGGER.info("No Bulgarian IBANs found to replace.");
    }
    return maskedOutput;
  }

}
