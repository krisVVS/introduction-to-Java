package com.onto.javacourse.objectsinjava.ontorobot;

import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OntoRobotTest {
    OntoRobot robot;

    @BeforeAll
    static void setupWorld() {
        World.setVisible(false);
        World.setDelay(0);
        World.setSize(50, 50);
    }

    @BeforeEach
    void setupRobot() {
        robot = new OntoRobot(5, 5, Directions.North, 10);
    }

    @Test
    void testGetStreet() {
        assertEquals(5, robot.getStreet());
    }

    @Test
    void testGetAvenue() {
        assertEquals(5, robot.getAvenue());
    }

    @Test
    void testGetBeepersCount() {
        assertEquals(10, robot.getBeepersCount());
    }

    @Test
    void testGetDirection() {
        assertEquals("North", robot.getDirection());
    }

    @Test
    void testTurnRight() {
        // Initially facing North, turn right should make it face East
        robot.turnRight();
        assertEquals("East", robot.getDirection());
    }

    @Test
    void testSetDifferentStreetAndAvenue() {
        robot = new OntoRobot(8, 12, Directions.South, 5); // Recreate robot with different values
        assertEquals(8, robot.getStreet());
        assertEquals(12, robot.getAvenue());
        assertEquals(5, robot.getBeepersCount());
        assertEquals("South", robot.getDirection());
    }
}
