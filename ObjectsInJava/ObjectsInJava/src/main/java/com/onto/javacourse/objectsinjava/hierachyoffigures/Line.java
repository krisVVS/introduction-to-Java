package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Class representing a line figure that can be drawn by an OntoRobot.
 */
public class Line extends Figure {

    /**
     * Draws a line using the specified robot and length parameter.
     *
     * @param robot the robot that will draw the line
     * @param params length of the line
     * @throws IllegalArgumentException if the number of parameters is not 1
     */
    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("Line requires only 1 parameter: length.");
        }

        int length = params[0];
        for (int i = 0; i < length; i++) {
            robot.putBeeper();
            robot.move();
        }
    }
}
