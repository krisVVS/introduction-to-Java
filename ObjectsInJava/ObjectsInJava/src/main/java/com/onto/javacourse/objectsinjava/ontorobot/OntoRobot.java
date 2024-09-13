package com.onto.javacourse.objectsinjava.ontorobot;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import kareltherobot.*;

public class OntoRobot extends UrRobot {
    private int currentX;
    private int currentY;
    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
        this.currentX = street;
        this.currentY = avenue;
    }

    public void turnRight() {
        World.setDelay(0);
        turnLeft();
        turnLeft();
        World.setDelay(30);
        turnLeft();
    }

    public void draw(Figure figure, int... params) {
        figure.draw(this, params);
    }
}