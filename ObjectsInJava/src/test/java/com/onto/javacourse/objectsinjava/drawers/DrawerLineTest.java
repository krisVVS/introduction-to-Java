package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Line;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawerLineTest {
  private OntoRobot robot;
  private DrawerLine drawerLine;

  @BeforeEach
  void setUp() {
    World.setSize(10, 10);
    World.setDelay(0);
    World.setVisible(false);

    robot = new OntoRobot(1, 1, Directions.East, 100);
    drawerLine = new DrawerLine();
  }

  @Test
  void testDrawLineHorizontal() {
    Point horizontalStart = new Point(1, 1);
    Point horizontalEnd = new Point(8, 1);
    Line horizontalLine = new Line(horizontalStart, horizontalEnd);
    drawerLine.draw(horizontalLine, robot);
    assertEquals(92, robot.getBeepers());
  }

  @Test
  void testDrawLineHorizontalFromBackToStart() {
    Point horizontalStart = new Point(8, 1);
    Point horizontalEnd = new Point(1, 1);
    Line horizontalLine = new Line(horizontalStart, horizontalEnd);
    drawerLine.draw(horizontalLine, robot);
    assertEquals(92, robot.getBeepers());
  }

  @Test
  void testDrawLineVerticle() {
    Point verticleStart = new Point(2, 1);
    Point verticleEnd = new Point(2, 8);
    Line verticleLine = new Line(verticleStart, verticleEnd);
    drawerLine.draw(verticleLine, robot);
    assertEquals(92, robot.getBeepers());
  }

  @Test
  void testDrawLineVerticleFromBackToStart() {
    Point verticleStart = new Point(2, 8);
    Point verticleEnd = new Point(2, 1);
    Line verticleLine = new Line(verticleStart, verticleEnd);
    drawerLine.draw(verticleLine, robot);
    assertEquals(92, robot.getBeepers());
  }

  @Test
  void testDrawLineDiagonal() {
    Point diagonalStart = new Point(1, 1);
    Point diagonalEnd = new Point(6, 6);
    Line diagonalLine = new Line(diagonalStart, diagonalEnd);
    drawerLine.draw(diagonalLine, robot);
    assertEquals(94, robot.getBeepers());
  }

  @Test
  void testDrawLineDiagonalFromBackToStart() {
    Point diagonalStart = new Point(6, 6);
    Point diagonalEnd = new Point(1, 1);
    Line diagonalLine = new Line(diagonalStart, diagonalEnd);
    drawerLine.draw(diagonalLine, robot);
    assertEquals(94, robot.getBeepers());
  }

  @Test
  void testDrawLineDiagonalTopLeftToBottomRight() {
    Point diagonalStart = new Point(1, 6);
    Point diagonalEnd = new Point(6, 1);
    Line diagonalLine = new Line(diagonalStart, diagonalEnd);
    drawerLine.draw(diagonalLine, robot);
    assertEquals(94, robot.getBeepers());
  }

  @Test
  void testDrawLineDiagonalTopLeftToBottomRightFromBackToStart() {
    Point diagonalStart = new Point(6, 1);
    Point diagonalEnd = new Point(1, 6);
    Line diagonalLine = new Line(diagonalStart, diagonalEnd);
    drawerLine.draw(diagonalLine, robot);
    assertEquals(94, robot.getBeepers());
  }

  @Test
  void testDrawLineSamePoint() {
    Point diagonalStart = new Point(1, 6);
    Point diagonalEnd = new Point(1, 6);
    Line diagonalLine = new Line(diagonalStart, diagonalEnd);
    drawerLine.draw(diagonalLine, robot);
    assertEquals(99, robot.getBeepers());
  }
}
