package com.onto.javacourse.intro.hangmangame;
import java.util.HashSet;
import java.util.Set;

/**
 * The HangmanModel class represents the logic and data of the Hangman game.
 * It keeps track of the word to guess, the letters guessed, and the number of remaining guesses.
 */
public class HangmanModel {
    private String wordToGuess;
    private Set<Character> guessedLetters;
    private int remainingGuesses;
    private StringBuilder currentGuess;

    /**
     * Constructs a new HangmanModel with the specified word and maximum number of guesses.
     *
     * @param wordToGuess the word to guess
     * @param maxGuesses  the maximum number of incorrect guesses allowed
     */
    public HangmanModel(String wordToGuess, int maxGuesses) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.remainingGuesses = maxGuesses;
        this.guessedLetters = new HashSet<>();
        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
    }

    /**
     * Makes a guess with the specified letter.
     *
     * @param letter the letter to guess
     * @return true if the letter is in the word, false otherwise
     */
    public boolean guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            System.out.println("Guess already guessed!");
            return false;
        }

        guessedLetters.add(letter);

        if (wordToGuess.indexOf(letter) >= 0) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    currentGuess.setCharAt(i, letter);
                }
            }
            return true;
        } else {
            remainingGuesses--;
            return false;
        }
    }

    /**
     * Checks if the game is over, either by guessing the word or running out of guesses.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return remainingGuesses <= 0 || wordToGuess.equals(currentGuess.toString());
    }

    /**
     * Checks if the word has been guessed correctly.
     *
     * @return true if the word has been guessed, false otherwise
     */
    public boolean isWordGuessed() {
        return wordToGuess.equals(currentGuess.toString());
    }

    /**
     * Gets the current state of the guessed word.
     *
     * @return the current state of the guessed word with guessed letters revealed and remaining letters as underscores
     */
    public String getCurrentGuess() {
        return currentGuess.toString();
    }

    /**
     * Gets the number of remaining guesses.
     *
     * @return the number of remaining guesses
     */
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    /**
     * Gets the set of guessed letters.
     *
     * @return the set of guessed letters
     */
    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    /**
     * Gets the word to guess.
     *
     * @return the word to guess
     */
    public String getWordToGuess() {
        return wordToGuess;
    }
}
