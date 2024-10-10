package com.onto.javacourse.objectsinjava.hierachyoffigures;

/**
 * Represents a line defined by a start and end point.
 * <p>
 * The {@code Line} class extends {@code Figure} and consists of two points:
 * a start point and an end point.
 * </p>
 */
public class Line extends Figure {
    private Point startPoint;
    private Point endPoint;

    /**
     * Constructs a {@code Line} with the given start and end points.
     *
     * @param startPoint the start point of the line
     * @param endPoint the end point of the line
     */
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
