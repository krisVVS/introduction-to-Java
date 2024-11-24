package com.onto.javacourse.intro.hangmangame;

import java.util.Scanner;
import java.util.Set;

/**
 * The HangmanView class handles the user interface for the Hangman game. It displays the game
 * status, prompts the user for input, and shows game over messages.
 */
public class HangmanView {
  private Scanner scanner;

  /** Constructs a new HangmanView and initializes the scanner for user input. */
  public HangmanView() {
    scanner = new Scanner(System.in);
  }

  /**
   * Displays the current status of the game.
   *
   * @param currentGuess the current state of the guessed word with guessed letters revealed and
   *     remaining letters as underscores
   * @param remainingGuesses the number of remaining guesses
   * @param guessedLetters the set of letters that have been guessed so far
   */
  public void displayGameStatus(
      String currentGuess, int remainingGuesses, Set<Character> guessedLetters) {
    System.out.println("Current word: " + currentGuess);
    System.out.println("Remaining guesses: " + remainingGuesses);
    System.out.println("Guessed letters: " + guessedLetters);
  }

  /**
   * Prompts the user to enter a letter and returns the input.
   *
   * @return the letter guessed by the user
   */
  public char getUserGuess() {
    System.out.print("Enter a letter: ");
    return scanner.nextLine().charAt(0);
  }

  /**
   * Displays a message indicating whether the game was won or lost.
   *
   * @param isWin true if the player has guessed the word correctly, false otherwise
   * @param wordToGuess the word that was being guessed
   */
  public void displayGameOver(boolean isWin, String wordToGuess) {
    if (isWin) {
      System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
    } else {
      System.out.println("Game Over! The word was: " + wordToGuess);
    }
  }
}
