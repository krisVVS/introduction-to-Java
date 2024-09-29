package com.onto.javacourse.objectsinjava.ontorobot;
import com.onto.javacourse.objectsinjava.drawers.DrawerFactory;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Figure;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import kareltherobot.*;

/**
 * Represents an OntoRobot that extends the functionality of UrRobot.
 * This robot can move, turn, and draw figures on a grid.
 */
public class OntoRobot extends UrRobot {
    private int street;
    private int avenue;
    private int beepers;
    private String direction;

    /**
     * Constructs an OntoRobot at the specified street and avenue.
     *
     * @param street    the initial street position of the robot.
     * @param avenue    the initial avenue position of the robot.
     * @param direction the initial direction the robot is facing.
     * @param beepers   the number of beepers the robot has.
     */
    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
        this.street = street;
        this.avenue = avenue;
        this.direction = direction.toString();
        this.beepers = beepers;
    }

    /**
     * Returns the current street position of the robot.
     *
     * @return the current street position.
     */
    public int getStreet() {
        return street;
    }

    /**
     * Returns the current avenue position of the robot.
     *
     * @return the current avenue position.
     */
    public int getAvenue() {
        return avenue;
    }

    /**
     * Returns the number of beepers remaining with the robot.
     *
     * @return the number of beepers.
     */
    public int getBeepers() {
        return beepers;
    }

    /**
     * Returns the current direction the robot is facing.
     *
     * @return the current direction.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Turns the robot to the right.
     */
    public void turningRight() {
        turnLeft();
        turnLeft();
        turnLeft();
        switch (direction) {
            case "East" -> direction = "South";
            case "South" -> direction = "West";
            case "West" -> direction = "North";
            case "North" -> direction = "East";
        }
    }

    /**
     * Turns the robot to the left.
     */
    public void turningLeft() {
        turnLeft();
        switch (direction) {
            case "East" -> direction = "North";
            case "South" -> direction = "East";
            case "West" -> direction = "South";
            case "North" -> direction = "West";
        }
    }

    /**
     * Moves the robot one step forward in the current direction.
     */
    public void forward() {
        move();
        switch (direction) {
            case "East" -> avenue += 1;
            case "South" -> street -= 1;
            case "West" -> avenue -= 1;
            case "North" -> street += 1;
        }
    }

    /**
     * Moves the robot to the specified avenue and street.
     *
     * @param avenue the target avenue.
     * @param street the target street.
     */
    public void moveTo(int avenue, int street) {
        if (street > this.street) {
            turnToDirection("North");
        }
        else if (street < this.street) {
            turnToDirection("South");
        }
        moveSteps(Math.abs(this.street - street));

        if (avenue > this.avenue) {
            turnToDirection("East");
        }
        else if (avenue < this.avenue) {
            turnToDirection("West");
        }
        moveSteps(Math.abs(this.avenue - avenue));
    }

    public void turnToDirection(String desiredDirection) {
        switch (direction) {
            case "North" -> {
                switch (desiredDirection) {
                    case "East" -> turningRight();
                    case "South" -> {
                        turningLeft();
                        turningLeft();
                    }
                    case "West" -> turningLeft();
                }
            }
            case "East" -> {
                switch (desiredDirection) {
                    case "South" -> turningRight();
                    case "West" -> {
                        turningLeft();
                        turningLeft();
                    }
                    case "North" -> turningLeft();
                }
            }
            case "South" -> {
                switch (desiredDirection) {
                    case "West" -> turningRight();
                    case "North" -> {
                        turningLeft();
                        turningLeft();
                    }
                    case "East" -> turningLeft();
                }
            }
            case "West" -> {
                switch (desiredDirection) {
                    case "North" -> turningRight();
                    case "East" -> {
                        turningLeft();
                        turningLeft();
                    }
                    case "South" -> turningLeft();
                }
            }
        }
        direction = desiredDirection;
    }

    private void moveSteps(int steps) {
        for (int i = 0; i < steps; i++) {
            forward();
        }
    }

    /**
     * Places a beeper at the current position of the robot and decreases the beeper count.
     */
    public void puttingBeeper() {
        putBeeper();
        beepers -= 1;
    }

    /**
     * Draws the specified figure using the appropriate drawer.
     *
     * @param figure the figure to be drawn.
     * @param <T>    the type of figure to be drawn.
     * @throws IllegalArgumentException if no drawer is found for the figure.
     */
    public <T extends Figure> void draw(T figure) {
        Drawer<T> drawer = DrawerFactory.getDrawer(figure);
        if (drawer != null) {
            drawer.draw(figure, this); // Draw the figure using the appropriate drawer
        } else {
            throw new IllegalArgumentException("No drawer found for figure: " + figure.getClass().getSimpleName());
        }
    }
}
