package com.onto.javacourse.objectsinjava.drawers;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Line;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

/**
 * The {@code DrawerLine} class implements the {@code Drawer} interface
 * for drawing {@code Line} objects using an {@code OntoRobot}.
 * <p>
 * This class contains the logic to draw a line segment between two points,
 * handling both vertical and horizontal lines, as well as diagonal lines.
 * </p>
 */
public class DrawerLine implements Drawer<Line> {

    /**
     * Draws a line using the specified {@code Line} object and {@code OntoRobot}.
     * The robot moves to the starting point of the line and places beepers
     * along the line based on the specified coordinates.
     *
     * @param line  the {@code Line} object that defines the start and end points
     * @param robot the {@code OntoRobot} used to perform the drawing
     */
    @Override
    public void draw(Line line, OntoRobot robot) {
        int startX = line.getStartPoint().getStartX();
        int startY = line.getStartPoint().getStartY();
        int endX = line.getEndPoint().getStartX();
        int endY = line.getEndPoint().getStartY();

        robot.moveTo(startX, startY);

        if (startX == endX) {
            for (int y = Math.min(startY, endY); y <= Math.max(startY, endY); y++) {
                robot.moveTo(startX, y);
                robot.puttingBeeper();
            }
            return;
        }

        if (startX > endX) {
            int bank = endX;
            endX = startX;
            startX = bank;
            int bank2 = endY;
            endY = startY;
            startY = bank2;
        }

        double slope = (double) (endY - startY) / (endX - startX);
        double intercept = startY - slope * startX;
        for (int x = startX; x <= endX; x++) {
            double y = slope * x + intercept;
            if (y == Math.floor(y)) {
                robot.moveTo(x, (int) y);
                robot.puttingBeeper();
            }
        }
    }
}
