package com.onto.javacourse.objectsinjava.ontorobot;
import kareltherobot.*;

/**
 * Represents an OntoRobot that extends the functionality of UrRobot.
 */
public class OntoRobot extends UrRobot {
    private int street;
    private int avenue;
    private int beepers;
    private String direction;

    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
        this.street = street;
        this.avenue = avenue;
        this.direction = direction.toString();
        this.beepers = beepers;
    }

    public int getStreet() {
        return street;
    }

    public int getAvenue() {
        return avenue;
    }

    public int getBeepers() {
        return beepers;
    }

    public String getDirection() {
        return direction;
    }

    public void turningRight() {
        World.setDelay(0);
        turnLeft();
        turnLeft();
        World.setDelay(0);
        turnLeft();
        switch (direction) {
            case "East" -> direction = "South";
            case "South" -> direction = "West";
            case "West" -> direction = "North";
            case "North" -> direction = "East";
        }
    }

    public void turningLeft() {
        turnLeft();
        switch (direction) {
            case "East" -> direction = "North";
            case "South" -> direction = "East";
            case "West" -> direction = "South";
            case "North" -> direction = "West";
        }
    }

    public void forward() {
        move();
        switch (direction) {
            case "East" -> avenue += 1;
            case "South" -> street -= 1;
            case "West" -> avenue -= 1;
            case "North" -> street += 1;
        }
    }

    public void puttingBeeper() {
        putBeeper();
        beepers -= 1;
    }
}
