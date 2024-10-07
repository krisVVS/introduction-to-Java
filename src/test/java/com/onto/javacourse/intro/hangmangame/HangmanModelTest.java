package com.onto.javacourse.intro.hangmangame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanModelTest {

    private HangmanModel model;

    @BeforeEach
    void setUp() {
        model = new HangmanModel("test", 6);
    }

    @Test
    void testInitialState() {
        assertEquals("____", model.getCurrentGuess());
        assertEquals(6, model.getRemainingGuesses());
        assertTrue(model.getGuessedLetters().isEmpty());
    }

    @Test
    void testGuessCorrectLetter() {
        model.guessLetter('t');
        assertEquals("t__t", model.getCurrentGuess());
        assertEquals(6, model.getRemainingGuesses());
    }

    @Test
    void testGuessIncorrectLetter() {
        model.guessLetter('a');
        assertEquals("____", model.getCurrentGuess());
        assertEquals(5, model.getRemainingGuesses());
    }

    @Test
    void testGameOver() {
        model.guessLetter('a');
        model.guessLetter('b');
        model.guessLetter('c');
        model.guessLetter('d');
        model.guessLetter('e');
        model.guessLetter('f');
        model.guessLetter('g'); // this should be the 7th incorrect guess
        assertTrue(model.isGameOver());
    }

    @Test
    void testWordGuessed() {
        model.guessLetter('t');
        model.guessLetter('e');
        model.guessLetter('t');
        model.guessLetter('s');
        assertTrue(model.isWordGuessed());
    }
}
