package com.onto.javacourse.objectsinjava.interfaces;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Figure;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * Represents a contract for drawing a specific type of figure using an OntoRobot.
 *
 * @param <T> the type of figure to be drawn, which must extend the {@link Figure} class.
 */
public interface Drawer<T extends Figure> {

    /**
     * Draws the specified figure using the given OntoRobot.
     *
     * @param figure the figure to be drawn.
     * @param robot  the OntoRobot used to perform the drawing actions.
     */
    void draw(T figure, OntoRobot robot);
}
