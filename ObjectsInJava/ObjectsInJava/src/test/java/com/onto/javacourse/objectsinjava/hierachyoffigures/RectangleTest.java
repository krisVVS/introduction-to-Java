package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
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
    void testDrawRectangleSuccessfully() {
        Rectangle rectangle = new Rectangle();
        robot.draw(rectangle, 3, 2);
        assertEquals(1, robot.getStreet());
        assertEquals(1, robot.getAvenue());
        assertEquals(4, robot.getBeepersCount());
    }

    @Test
    void testDrawRectangleInvalidParams() {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> robot.draw(rectangle));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(rectangle, 3));
        assertThrows(IllegalArgumentException.class, () -> robot.draw(rectangle, 3, 2, 5));
    }
}
