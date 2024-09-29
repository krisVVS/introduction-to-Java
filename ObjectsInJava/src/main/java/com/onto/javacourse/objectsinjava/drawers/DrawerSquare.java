package com.onto.javacourse.objectsinjava.drawers;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Square;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * The {@code DrawerSquare} class implements the {@code Drawer} interface
 * for drawing {@code Square} objects using an {@code OntoRobot}.
 * This class contains the logic to draw a square on a grid by placing beepers
 * at the corners and along the edges according to the specified width.
 */
public class DrawerSquare implements Drawer<Square> {

    /**
     * Draws a square using the specified {@code Square} object and {@code OntoRobot}.
     * The robot moves to the starting point of the square and places beepers
     * along its edges based on the square's dimensions.
     *
     * @param square the {@code Square} object that defines the dimensions and position
     *               of the square to draw
     * @param robot the {@code OntoRobot} used to perform the drawing
     */
    @Override
    public void draw(Square square, OntoRobot robot) {
        robot.moveTo(square.getStartPoint().getStartX(), square.getStartPoint().getStartY());

        switch (robot.getDirection()) {
            case "South" -> robot.turningLeft();
            case "North" -> robot.turningRight();
            case "West" -> {
                robot.turningLeft();
                robot.turningLeft();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < square.getWidth(); j++) {
                robot.forward();
                robot.puttingBeeper();
            }
            robot.turningLeft();
        }
    }
}
