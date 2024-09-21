package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Represents a dot figure that can be drawn by an OntoRobot.
 */
public class Dot extends Figure {

    /**
     * Draws the dot by placing a beeper at the robot's current position.
     *
     * @param robot the robot that will draw the dot
     * @param params parameters for the draw method
     * @throws IllegalArgumentException if parameters are provided
     */
    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 0) {
            throw new IllegalArgumentException("Dot does not accept parameters");
        }
        robot.putBeeper();
    }
}
