package com.onto.javacourse.objectsinjava.ontorobot;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Figure;
import kareltherobot.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OntoRobotTest {

  private OntoRobot robot;

  @BeforeEach
  void setUp() {
    robot = new OntoRobot(1, 1, Directions.East, 10);
  }

  @Test
  void testInitialPosition() {
    assertEquals(1, robot.getStreet());
    assertEquals(1, robot.getAvenue());
    assertEquals(10, robot.getBeepers());
    assertEquals("East", robot.getDirection());
  }

  @Test
  void testTurningRight() {
    robot.turningRight();
    assertEquals("South", robot.getDirection());
    robot.turningRight();
    assertEquals("West", robot.getDirection());
    robot.turningRight();
    assertEquals("North", robot.getDirection());
    robot.turningRight();
    assertEquals("East", robot.getDirection());
  }

  @Test
  void testTurningLeft() {
    robot.turningLeft();
    assertEquals("North", robot.getDirection());
    robot.turningLeft();
    assertEquals("West", robot.getDirection());
    robot.turningLeft();
    assertEquals("South", robot.getDirection());
    robot.turningLeft();
    assertEquals("East", robot.getDirection());
  }

  @Test
  void testMoveForwardEast() {
    robot.forward();
    assertEquals(1, robot.getStreet());
    assertEquals(2, robot.getAvenue());
  }

  @Test
  void testMoveForwardNorth() {
    robot.turningLeft();
    robot.forward();
    assertEquals(2, robot.getStreet());
    assertEquals(1, robot.getAvenue());
  }

  @Test
  void testMoveForwardSouth() {
    robot.turningRight();
    robot.forward();
    assertEquals(0, robot.getStreet());
    assertEquals(1, robot.getAvenue());
  }

  @Test
  void testMoveForwardWest() {
    robot.turningLeft();
    robot.turningLeft();
    robot.forward();
    assertEquals(1, robot.getStreet());
    assertEquals(0, robot.getAvenue());
  }

  @Test
  void testMoveToDifferentPosition() {
    robot.moveTo(3, 4);
    assertEquals(4, robot.getStreet());
    assertEquals(3, robot.getAvenue());
  }

  @Test
  void testMoveToSamePosition() {
    robot.moveTo(1, 1);
    assertEquals(1, robot.getStreet());
    assertEquals(1, robot.getAvenue());
  }

  @Test
  void testPuttingBeeper() {
    int initialBeepers = robot.getBeepers();
    robot.puttingBeeper();
    assertEquals(initialBeepers - 1, robot.getBeepers());
  }

  @Test
  void testDrawPoint() {
    Point point = new Point(3, 4);
    robot.draw(point);
    assertEquals(3, robot.getAvenue());
    assertEquals(4, robot.getStreet());
  }

  @Test
  void testDrawUnsupportedFigure() {
    Figure unsupportedFigure = new Figure() {};
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> robot.draw(unsupportedFigure));
    assertEquals("No drawer found for figure:", exception.getMessage().trim());
  }

  @Test
  void testTurnToDirectionEastToNorth() {
    robot.turnToDirection("North");
    assertEquals("North", robot.getDirection());
  }

  @Test
  void testTurnToDirectionNorthToWest() {
    robot.turningLeft();
    assertEquals("North", robot.getDirection());
    robot.turnToDirection("West");
    assertEquals("West", robot.getDirection());
  }

  @Test
  void testTurnToDirectionSouthToEast() {
    robot.turningRight();
    assertEquals("South", robot.getDirection());
    robot.turnToDirection("East");
    assertEquals("East", robot.getDirection());
  }

  @Test
  void testTurnToDirectionEastToWest() {
    robot.turningLeft();
    robot.turningLeft();
    robot.turnToDirection("West");
    assertEquals("West", robot.getDirection());
  }

  @Test
  void testTurnToDirectionSouthToNorth() {
    robot.turningRight();
    robot.turnToDirection("North");
    assertEquals("North", robot.getDirection());
  }

  @Test
  void testMoveSteps() {
    robot.moveTo(1, 4);
    assertEquals(4, robot.getStreet());
    assertEquals(1, robot.getAvenue());

    robot.moveTo(3, 4);
    assertEquals(4, robot.getStreet());
    assertEquals(3, robot.getAvenue());
  }
}
