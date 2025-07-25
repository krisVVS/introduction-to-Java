package com.onto.javacourse.stopcounterthread;

import java.util.Scanner;

public class StarterThread {
  public static void begin(int count) {
    StopCounter stopCounter = new StopCounter(count);
    Thread thread = new Thread(stopCounter);
    thread.setDaemon(true);
    thread.start();
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

  }
}
