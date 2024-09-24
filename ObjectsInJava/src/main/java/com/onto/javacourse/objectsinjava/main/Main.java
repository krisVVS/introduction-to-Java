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
        System.out.println(robot.getDirection());
        System.out.println(robot.getStreet());
        System.out.println(robot.getAvenue());
        System.out.println(robot.getBeepers());

        robot.forward();
        System.out.println(robot.getDirection());
        System.out.println(robot.getStreet());
        System.out.println(robot.getAvenue());
        System.out.println(robot.getBeepers());

        robot.turningRight();
        System.out.println(robot.getDirection());
        System.out.println(robot.getStreet());
        System.out.println(robot.getAvenue());
        System.out.println(robot.getBeepers());

        robot.turningLeft();
        robot.turningLeft();
        robot.forward();
        System.out.println(robot.getDirection());
        System.out.println(robot.getStreet());
        System.out.println(robot.getAvenue());
        System.out.println(robot.getBeepers());


    }
}