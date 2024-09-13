package com.onto.javacourse.objectsinjava;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.*;
import static kareltherobot.Directions.East;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        World.setVisible(true);
        World.setDelay(30);
        OntoRobot robot = new OntoRobot(1, 1, East, 100);
        Figure dot = new Dot();
        Figure line = new Line();
        Figure square = new Square();
        Figure rectangle = new Rectangle();
        robot.move();
        robot.turnLeft();
        robot.move();
        robot.turnRight();

        robot.draw(line, 4);
        robot.move();
    }
}