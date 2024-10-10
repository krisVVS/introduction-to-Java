package com.onto.javacourse.objectsinjava.drawers;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Rectangle;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * The {@code DrawerRectangle} class implements the {@code Drawer} interface
 * for drawing {@code Rectangle} objects using an {@code OntoRobot}.
 * <p>
 * This class contains the logic to draw a rectangle on a grid by placing beepers
 * at the corners and along the edges according to the specified width and height.
 * </p>
 */
public class DrawerRectangle implements Drawer<Rectangle> {

    /**
     * Draws a rectangle using the specified {@code Rectangle} object and {@code OntoRobot}.
     * The robot moves to the starting point of the rectangle and places beepers
     * along its edges based on the rectangle's dimensions.
     *
     * @param rectangle the {@code Rectangle} object that defines the dimensions and position
     *                  of the rectangle to draw
     * @param robot the {@code OntoRobot} used to perform the drawing
     */
    @Override
    public void draw(Rectangle rectangle, OntoRobot robot) {
        robot.moveTo(rectangle.getStartPoint().getStartX(), rectangle.getStartPoint().getStartY());

        switch (robot.getDirection()) {
            case "South" -> robot.turningLeft();
            case "North" -> robot.turningRight();
            case "West" -> {
                robot.turningLeft();
                robot.turningLeft();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < rectangle.getWidth(); j++) {
                robot.forward();
                robot.puttingBeeper();
            }
            robot.turningLeft();
            for (int j = 1; j < rectangle.getHeight(); j++) {
                robot.forward();
                robot.puttingBeeper();
            }
            robot.turningLeft();
        }
    }
}
