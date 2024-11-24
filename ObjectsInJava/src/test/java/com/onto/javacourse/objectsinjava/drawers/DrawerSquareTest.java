package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Square;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawerSquareTest {

  private OntoRobot robot;
  private DrawerSquare drawerSquare;

  @BeforeEach
  void setUp() {
    World.setSize(10, 10);
    World.setVisible(false);

    robot = new OntoRobot(1, 1, Directions.East, 100);
    drawerSquare = new DrawerSquare();
  }

  @Test
  void testDrawSquareOfWidth3() {
    Square square = new Square(new Point(1, 1), 3);
    drawerSquare.draw(square, robot);

    assertEquals(1, robot.getStreet());
    assertEquals(1, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(92, robot.getBeepers());
  }

  @Test
  void testDrawSquareOfWidth2() {
    Square square = new Square(new Point(2, 2), 2);
    drawerSquare.draw(square, robot);

    assertEquals(2, robot.getStreet());
    assertEquals(2, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(96, robot.getBeepers());
  }

  @Test
  void testDrawSquareOfWidth5() {
    Square square = new Square(new Point(3, 3), 5);
    drawerSquare.draw(square, robot);

    assertEquals(3, robot.getStreet());
    assertEquals(3, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(84, robot.getBeepers());
  }

  @Test
  void testDrawSquareStartingInSouthDirection() {
    OntoRobot robot2 = new OntoRobot(5, 5, Directions.South, 100);
    Square square = new Square(new Point(5, 5), 4);
    drawerSquare.draw(square, robot2);

    assertEquals(5, robot2.getStreet());
    assertEquals(5, robot2.getAvenue());
    assertEquals("East", robot2.getDirection());
    assertEquals(88, robot2.getBeepers());
  }

  @Test
  void testDrawSquareStartingInNorthDirection() {
    OntoRobot robot2 = new OntoRobot(5, 5, Directions.North, 100);
    Square square = new Square(new Point(5, 5), 4);
    drawerSquare.draw(square, robot2);

    assertEquals(5, robot2.getStreet());
    assertEquals(5, robot2.getAvenue());
    assertEquals("East", robot2.getDirection());
    assertEquals(88, robot2.getBeepers());
  }

  @Test
  void testDrawSquareStartingInWestDirection() {
    OntoRobot robot2 = new OntoRobot(5, 5, Directions.West, 100);
    Square square = new Square(new Point(5, 5), 4);
    drawerSquare.draw(square, robot2);

    assertEquals(5, robot2.getStreet());
    assertEquals(5, robot2.getAvenue());
    assertEquals("East", robot2.getDirection());
    assertEquals(88, robot2.getBeepers());
  }
}
