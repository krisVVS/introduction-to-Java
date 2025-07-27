package com.onto.javacourse.stopcounterthread;

import java.util.Scanner;

/**
 * This class starts a counter thread and provides an option to stop it early
 * based on user input.
 */
public class StarterThread {

  /**
   * Begins counting in a separate thread up to the specified number.
   * If the user presses Enter before the counter finishes, the counter thread is interrupted.
   * If the counter finishes normally, a provided exit handler is
   * executed (e.g., to shut down the application).
   *
   * @param count       the number to count up to, once per second
   * @param scanner     the Scanner used to capture user input (usually System.in)
   * @param exitHandler a Runnable that defines the behavior when the counter finishes
   */
  public static void begin(int count, Scanner scanner, Runnable exitHandler) {
    StopCounter stopCounter = new StopCounter(count, () -> exitHandler.run());
    Thread thread = new Thread(stopCounter);
    thread.start();

    System.out.println("Press Enter to stop the counter early...");
    scanner.nextLine();
    thread.interrupt();
  }
}
