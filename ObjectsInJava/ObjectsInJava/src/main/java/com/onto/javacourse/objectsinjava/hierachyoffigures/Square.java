package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

public class Square extends Figure{

    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("Square requires only 1 parameter: side length.");
        }
        int sideLength = params[0];
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < sideLength; j++){
                robot.putBeeper();
                robot.move();
            }
            robot.turnLeft();
        }
    }
}
