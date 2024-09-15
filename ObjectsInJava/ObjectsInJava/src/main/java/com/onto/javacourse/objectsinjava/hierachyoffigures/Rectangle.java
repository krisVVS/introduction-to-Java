package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

public class Rectangle extends Figure  {

    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Rectangle requires at least 2 parameters: width and height.");
        }
        int width = params[0];
        int height = params[1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < width; j++) {
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
            for (int j = 1; j < height; j++) {
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
        }
    }
}
