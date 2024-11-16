package com.onto.javacourse.objectsinjava.hierachyoffigures;

/**
 * Represents a square, defined by a start point and width.
 * <p>
 * The {@code Square} class extends {@code Figure}, storing the bottom-left corner (start point)
 * and the width, which represents the side length of the square.
 * </p>
 */
public class Square extends Figure {
    private Point startPoint;
    private int width;

    /**
     * Constructs a {@code Square} with the given start point and width.
     *
     * @param startPoint the starting point (bottom-left corner) of the square
     * @param width the width (side length) of the square
     */
    public Square(Point startPoint, int width) {
        this.startPoint = startPoint;
        this.width = width;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public int getWidth() {
        return width;
    }
}
