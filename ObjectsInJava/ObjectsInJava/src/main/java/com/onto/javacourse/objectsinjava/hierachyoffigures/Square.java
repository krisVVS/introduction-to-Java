package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Represents a square shape that can be drawn by an OntoRobot.
 */
public class Square extends Figure {

    /**
     * Draws the square using the specified side length.
     *
     * @param robot  The OntoRobot used to draw the square.
     * @param params An array where params[0] is the side length of the square.
     * @throws IllegalArgumentException if the number of parameters is not exactly 1.
     */
    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("Square requires only 1 parameter: side length.");
        }
        int sideLength = params[0];
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < sideLength; j++) {
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
        }
    }
}
