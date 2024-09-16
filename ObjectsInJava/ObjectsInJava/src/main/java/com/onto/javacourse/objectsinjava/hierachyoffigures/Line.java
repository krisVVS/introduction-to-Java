package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

public class Line extends Figure{

    @Override
    public void draw(OntoRobot robot,  int... params) {
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
