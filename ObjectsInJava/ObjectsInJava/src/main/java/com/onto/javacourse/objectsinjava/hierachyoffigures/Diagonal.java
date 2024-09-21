package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Represents a diagonal figure that can be drawn by an OntoRobot.
 */
public class Diagonal extends Figure {

    /**
     * Draws a diagonal using the specified robot.
     *
     * @param robot  the OntoRobot used to draw the diagonal
     * @param params an array containing the length of the diagonal and the direction
     *               (1 for bottom-left to top-right, -1 for top-left to bottom-right)
     * @throws IllegalArgumentException if the length and direction are not provided
     */
    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Diagonal requires at least 2 parameters: length and direction.");
        }

        int length = params[0];
        int direction = params[1];

        for (int i = 0; i < length; i++) {
            robot.putBeeper();

            if (direction == 1 && i != length - 1) {
                robot.move();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
            } else if (direction == -1 && i != length - 1) {
                robot.move();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
            }
        }
    }
}
