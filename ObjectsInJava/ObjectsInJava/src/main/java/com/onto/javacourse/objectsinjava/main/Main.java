package com.onto.javacourse.objectsinjava.main;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import com.onto.javacourse.objectsinjava.ontorobot.OntoRobot;
import kareltherobot.*;
import static kareltherobot.Directions.East;
import static kareltherobot.Directions.North;

public class Main {
    public static void main(String[] args) {
        World.setVisible(true);
        World.setDelay(0);
        World.setSize(50, 50);
        Figure dot = new Dot();
        Figure line = new Line();
        Figure diagonal = new Diagonal();
        Figure square = new Square();
        Figure rectangle = new Rectangle();

        OntoRobot robotStreet = new OntoRobot(10,1, East, 100);
        OntoRobot robotSquare = new OntoRobot(10, 10, East, 900);
        OntoRobot robotDoor = new OntoRobot(10, 20, North, 50);
        OntoRobot robotDoorHandle = new OntoRobot(14, 19, North, 1);
        OntoRobot robotDiagonal = new OntoRobot(34, 10, East, 100);
        OntoRobot robotWindow = new OntoRobot(22, 27, East, 100);

        robotStreet.draw(line, 50);
        robotSquare.draw(rectangle, 29, 25);
        robotDoor.draw(rectangle, 10, 5);
        robotDoorHandle.draw(dot);
        robotDiagonal.draw(diagonal,15, 1);
        robotDiagonal.draw(diagonal, 15, -1);
        robotWindow.draw(square, 8);

    }
}