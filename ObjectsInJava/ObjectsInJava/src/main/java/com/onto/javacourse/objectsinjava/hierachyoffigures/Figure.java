package com.onto.javacourse.objectsinjava.hierachyoffigures;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Abstract class representing a geometric figure that can be drawn by an OntoRobot.
 */
public abstract class Figure {

    /**
     * Draws the figure using the specified robot and parameters.
     *
     * @param robot the robot that will draw the figure
     * @param params parameters specific to the figure
     */
    public abstract void draw(OntoRobot robot, int... params);
}
