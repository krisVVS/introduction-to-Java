package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Rectangle;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawerRectangleTest {

  private OntoRobot robot;
  private DrawerRectangle drawerRectangle;

  @BeforeEach
  void setUp() {
    World.setSize(10, 10);
    World.setVisible(false);

    robot = new OntoRobot(1, 1, Directions.East, 20);
    drawerRectangle = new DrawerRectangle();
  }

  @Test
  void testDrawRectangleWidth3Height2() {
    Rectangle rectangle = new Rectangle(new Point(1, 1), 3, 2);
    drawerRectangle.draw(rectangle, robot);

    assertEquals(1, robot.getStreet());
    assertEquals(1, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(14, robot.getBeepers());
  }

  @Test
  void testDrawRectangleWidth4Height3() {
    Rectangle rectangle = new Rectangle(new Point(2, 2), 4, 3);
    drawerRectangle.draw(rectangle, robot);

    assertEquals(2, robot.getStreet());
    assertEquals(2, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(10, robot.getBeepers());
  }

  @Test
  void testDrawRectangleStartingInSouthDirection() {
    robot = new OntoRobot(5, 5, Directions.South, 20);
    Rectangle rectangle = new Rectangle(new Point(5, 5), 5, 4);
    drawerRectangle.draw(rectangle, robot);

    assertEquals(5, robot.getStreet());
    assertEquals(5, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(6, robot.getBeepers());
  }

  @Test
  void testDrawRectangleStartingInNorthDirection() {
    robot = new OntoRobot(5, 5, Directions.North, 20);
    Rectangle rectangle = new Rectangle(new Point(5, 5), 5, 4);
    drawerRectangle.draw(rectangle, robot);

    assertEquals(5, robot.getStreet());
    assertEquals(5, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(6, robot.getBeepers());
  }

  @Test
  void testDrawRectangleStartingInWestDirection() {
    robot = new OntoRobot(5, 5, Directions.West, 20);
    Rectangle rectangle = new Rectangle(new Point(5, 5), 5, 4);
    drawerRectangle.draw(rectangle, robot);

    assertEquals(5, robot.getStreet());
    assertEquals(5, robot.getAvenue());
    assertEquals("East", robot.getDirection());
    assertEquals(6, robot.getBeepers());
  }
}
