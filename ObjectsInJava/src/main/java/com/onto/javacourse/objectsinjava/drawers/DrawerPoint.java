package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * The {@code DrawerPoint} class implements the {@code Drawer} interface for drawing {@code Point}
 * objects using an {@code OntoRobot}.
 *
 * <p>This class contains the logic to place a beeper at a specified point in the grid, represented
 * by its coordinates.
 */
public class DrawerPoint implements Drawer<Point> {

  /**
   * Draws a point using the specified {@code Point} object and {@code OntoRobot}. The robot moves
   * to the coordinates of the point and places a beeper there.
   *
   * @param point the {@code Point} object that defines the coordinates to draw
   * @param robot the {@code OntoRobot} used to perform the drawing
   */
  @Override
  public void draw(Point point, OntoRobot robot) {
    robot.moveTo(point.getStartX(), point.getStartY());
    robot.puttingBeeper();
  }
}
