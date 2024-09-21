package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
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
    void testDrawLineSuccessfully() {
        Line line = new Line();
        robot.draw(line, 5);
        assertEquals(1, robot.getStreet());
        assertEquals(6, robot.getAvenue());
        assertEquals(5, robot.getBeepersCount());
    }

    @Test
    void testDrawLineInvalidParams() {
        Line line = new Line();

        // Line should throw an exception if invalid parameters are passed
        assertThrows(IllegalArgumentException.class, () -> robot.draw(line));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(line, 5, 10));
    }
}
