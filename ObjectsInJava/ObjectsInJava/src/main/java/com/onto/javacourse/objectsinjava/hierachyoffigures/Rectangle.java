package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Represents a rectangle shape that can be drawn by an OntoRobot.
 */
public class Rectangle extends Figure {

    /**
     * Draws the rectangle using the specified width and height.
     *
     * @param robot  The OntoRobot used to draw the rectangle.
     * @param params An array where params[0] is the width and params[1] is the height of the rectangle.
     * @throws IllegalArgumentException if the number of parameters is not exactly 2.
     */
    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Rectangle requires at least 2 parameters: width and height.");
        }
        int width = params[0];
        int height = params[1];

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < width; j++) {
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
            for (int j = 1; j < height; j++) {
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
        }
    }
}
