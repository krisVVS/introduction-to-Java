package com.onto.javacourse.objectsinjava.ontorobot;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import kareltherobot.*;

public class OntoRobot extends UrRobot {

    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }

    public void turnRight() {
        World.setDelay(0);
        turnLeft();
        turnLeft();
        World.setDelay(0);
        turnLeft();
    }

    public void draw(Figure figure, int... params) {
        figure.draw(this, params);
    }

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

        robotStreet.draw(line, 20);
        robotStreet.showState("positon");
    }
}