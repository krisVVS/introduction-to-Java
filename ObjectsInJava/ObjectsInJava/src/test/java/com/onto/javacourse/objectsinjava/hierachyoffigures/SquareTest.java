package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    OntoRobot robot;

    @BeforeAll
    static void setupWorld() {
        World.setVisible(false);
        World.setDelay(0);
        World.setSize(50, 50);
    }

    @BeforeEach
    void setupRobot() {
        robot = new OntoRobot(1, 1, kareltherobot.Directions.East, 10);
    }

    @Test
    void testDrawSquareSuccessfully() {
        Square square = new Square();
        robot.draw(square, 3);
        assertEquals(1, robot.getStreet());
        assertEquals(1, robot.getAvenue());
        assertEquals(2, robot.getBeepersCount());
    }

    @Test
    void testDrawSquareInvalidParams() {
        Square square = new Square();
        assertThrows(IllegalArgumentException.class, () -> robot.draw(square));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(square, 4, 5));
    }
}
