package com.onto.javacourse.intro.hangmangame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordGeneratorTest {

    @Test
    void testRandomWords() {
        String word = WordGenerator.randomWords();
        assertNotNull(word);
        assertFalse(word.isEmpty());
    }
}
