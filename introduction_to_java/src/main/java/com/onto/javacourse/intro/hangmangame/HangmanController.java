package com.onto.javacourse.intro.hangmangame;

/**
 * The HangmanController class connects the model and view, handling the flow of the Hangman game.
 */
public class HangmanController {
  private HangmanModel model;
  private HangmanView view;
  private WordGenerator wordGenerator;

  /**
   * Constructs a new HangmanController with the specified model, view, and word generator.
   *
   * @param model the HangmanModel containing the game logic
   * @param view the HangmanView for user interaction
   * @param wordGenerator the WordGenerator for providing a random word to guess
   */
  public HangmanController(HangmanModel model, HangmanView view, WordGenerator wordGenerator) {
    this.model = model;
    this.view = view;
    this.wordGenerator = wordGenerator;
  }

  /** Starts the Hangman game, managing the main game loop until the game is over. */
  public void startGame() {
    String wordToGuess = wordGenerator.randomWords();
    model = new HangmanModel(wordToGuess, 6);

    while (!model.isGameOver()) {
      view.displayGameStatus(
          model.getCurrentGuess(), model.getRemainingGuesses(), model.getGuessedLetters());
      char guess = view.getUserGuess();
      model.guessLetter(guess);
    }
    view.displayGameOver(model.isWordGuessed(), model.getWordToGuess());
  }

  /**
   * The main method to start the Hangman game.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    WordGenerator wordGenerator = new WordGenerator();
    HangmanView view = new HangmanView();
    HangmanController controller = new HangmanController(null, view, wordGenerator);
    controller.startGame();
  }
}
