package com.onto.javacourse.objectsinjava.ontorobot;
import kareltherobot.*;

public class OntoRobot extends UrRobot {

    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }

    public void turnRight() {
        World.setDelay(0);
        turnLeft();
        turnLeft();
        World.setDelay(100);
        turnLeft();
    }

    public static void main(String[] args) {
        World.setVisible(true);
        World.setDelay(100);
        OntoRobot robot = new OntoRobot(1, 1, East, 2);
        robot.move();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.move();
    }
}