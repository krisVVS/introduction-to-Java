package com.onto.javacourse.objectsinjava.main;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.*;
import static kareltherobot.Directions.East;
import static kareltherobot.Directions.North;

public class Main {
    public static void main(String[] args) {
        OntoRobot robot = new OntoRobot(1, 2, East, 29);
        World.setSize(40,50);
        World.setVisible();
        World.setDelay(0);

        robot.moveTo(12,15);


    }
}