package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

public class Diagonal extends Figure {

    @Override
    public void draw(OntoRobot robot, int... params) {
        // Ensure there are enough parameters
        if (params.length != 2) {
            throw new IllegalArgumentException("Diagonal requires at least 2 parameters: length and direction.");
        }

        int length = params[0]; // Length of the diagonal
        int direction = params[1]; // Direction: 1 for bottom-left to top-right, -1 for top-left to bottom-right

        // Draw the diagonal
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
