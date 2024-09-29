package com.onto.javacourse.objectsinjava.main;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Line;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Point;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Rectangle;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Square;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.*;
import static kareltherobot.Directions.East;

public class Main {
    public static void main(String[] args) {
        OntoRobot robot = new OntoRobot(1, 2, East, 2000);
        World.setSize(50,50);
        World.setVisible();
        World.setDelay(0);

        Point startRectangleHouse = new Point(10,5);
        Rectangle rectangleHouse = new Rectangle(startRectangleHouse,31,25);
        robot.draw(rectangleHouse);

        Point rectangleDoorStart = new Point(15,5);
        Rectangle rectangleDoor = new Rectangle(rectangleDoorStart,4,10);
        robot.draw(rectangleDoor);

        Point squareWindowStart = new Point(27, 17);
        Square squareWindow = new Square(squareWindowStart,8);
        robot.draw(squareWindow);

        Point startRoof = new Point(10, 29);
        Point endRoof = new Point(25, 44);
        Line startRoofLine = new Line(startRoof,endRoof);
        robot.draw(startRoofLine);

        Point startRoof2 = new Point(25, 44);
        Point endRoof2 = new Point(40, 29);
        Line endRoofLine = new Line(startRoof2,endRoof2);
        robot.draw(endRoofLine);
        robot.forward();

    }
}