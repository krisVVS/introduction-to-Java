package com.onto.javacourse.objectsinjava.hierachyoffigures;

/**
 * Represents a point in a 2D space with x and y coordinates.
 *
 * <p>The {@code Point} class extends {@code Figure} and stores the coordinates of a point in 2D
 * space using integers for the x (startX) and y (startY) values.
 */
public class Point extends Figure {
  private int startX;
  private int startY;

  /**
   * Constructs a {@code Point} with the given x and y coordinates.
   *
   * @param startX the x-coordinate of the point
   * @param startY the y-coordinate of the point
   */
  public Point(int startX, int startY) {
    this.startX = startX;
    this.startY = startY;
  }

  public int getStartX() {
    return startX;
  }

  public int getStartY() {
    return startY;
  }
}
