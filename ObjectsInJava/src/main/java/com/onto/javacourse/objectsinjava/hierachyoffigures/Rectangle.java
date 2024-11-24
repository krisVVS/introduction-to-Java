package com.onto.javacourse.objectsinjava.hierachyoffigures;

/**
 * Represents a rectangle, defined by a start point, width, and height.
 *
 * <p>The {@code Rectangle} class extends {@code Square}, adding a height dimension.
 */
public class Rectangle extends Square {
  private int height;

  /**
   * Constructs a {@code Rectangle} with the given start point, width, and height.
   *
   * @param startPoint the starting point of the rectangle
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public Rectangle(Point startPoint, int width, int height) {
    super(startPoint, width);
    this.height = height;
  }

  public int getHeight() {
    return height;
  }
}
