package com.onto.javacourse.objectsinjava.hierachyoffigures;

import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;

public class Dot extends Figure{

    @Override
    public void draw(OntoRobot robot, int... params) {
        if (params.length != 0) {
            throw new IllegalArgumentException("Dot does not accept parameters");
        }
        robot.putBeeper();
    }
}
