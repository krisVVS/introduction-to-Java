package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagonalTest {
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
    void testDrawDiagonalSuccessfully() {
        Diagonal diagonal = new Diagonal();
        robot.draw(diagonal, 3, 1);
        assertEquals(3, robot.getStreet());
        assertEquals(3, robot.getAvenue());
        robot.draw(diagonal, 3, -1);
        assertEquals(1, robot.getStreet());
        assertEquals(5, robot.getAvenue());
        assertEquals(4, robot.getBeepersCount());
    }

    @Test
    void testDrawDiagonalInvalidParams() {
        Diagonal diagonal = new Diagonal();
        assertThrows(IllegalArgumentException.class, () -> robot.draw(diagonal));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(diagonal, 3));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(diagonal, 3, 1, 5));
    }
}
