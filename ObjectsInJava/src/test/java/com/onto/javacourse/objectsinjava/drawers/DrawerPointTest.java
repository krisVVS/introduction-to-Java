package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawerPointTest {

  private OntoRobot robot;
  private DrawerPoint drawerPoint;

  @BeforeEach
  void setUp() {
    World.setSize(10, 10);
    World.setDelay(0);
    World.setVisible(false);

    robot = new OntoRobot(1, 1, Directions.East, 10);
    drawerPoint = new DrawerPoint();
  }

  @Test
  void testDrawPoint() {
    Point point = new Point(3, 4);
    drawerPoint.draw(point, robot);
    assertEquals(9, robot.getBeepers());
  }
}
