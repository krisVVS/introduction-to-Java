package com.onto.javacourse.objectsinjava.ontorobot;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import kareltherobot.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Represents an OntoRobot that extends the functionality of UrRobot.
 */
public class OntoRobot extends UrRobot {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outputStream);
    private PrintStream originalOut = System.out;

    /**
     * Constructs an OntoRobot at the specified location.
     *
     * @param street   the street number
     * @param avenue   the avenue number
     * @param direction the direction the robot is facing
     * @param beepers   the number of beepers the robot starts with
     */
    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }

    /**
     * Turns the robot 90 degrees to the right.
     */
    public void turnRight() {
        World.setDelay(0);
        turnLeft();
        turnLeft();
        World.setDelay(0);
        turnLeft();
    }

    /**
     * Draws the specified figure using the robot.
     *
     * @param figure the figure to be drawn
     * @param params parameters for the figure's draw method
     */
    public void draw(Figure figure, int... params) {
        figure.draw(this, params);
    }

    /**
     * Retrieves the current street number of the robot.
     *
     * @return the current street number
     */
    public int getStreet() {
        System.setOut(printStream);
        outputStream.reset();
        showState("");

        String state = outputStream.toString().trim();
        int startIndex = state.indexOf("street: ") + 8;
        int parenthesisIndex = state.indexOf(")", startIndex);

        int street = Integer.parseInt(state.substring(startIndex, parenthesisIndex));
        System.setOut(originalOut);
        return street;
    }

    /**
     * Retrieves the current avenue number of the robot.
     *
     * @return the current avenue number
     */
    public int getAvenue() {
        System.setOut(printStream);
        outputStream.reset();
        showState("");

        String state = outputStream.toString().trim();
        int startIndex = state.indexOf("avenue: ") + 8;
        int parenthesisIndex = state.indexOf(")", startIndex);

        int avenue = Integer.parseInt(state.substring(startIndex, parenthesisIndex));
        System.setOut(originalOut);
        return avenue;
    }

    /**
     * Retrieves the number of beepers the robot currently has.
     *
     * @return the number of beepers
     */
    public int getBeepersCount() {
        System.setOut(printStream);
        outputStream.reset();
        showState("");

        String state = outputStream.toString().trim();
        int startIndex = state.indexOf("beepers: ") + 9;
        int parenthesisIndex = state.indexOf(")", startIndex);

        int beepersCount = Integer.parseInt(state.substring(startIndex, parenthesisIndex));
        System.setOut(originalOut);
        return beepersCount;
    }

    /**
     * Retrieves the current direction the robot is facing.
     *
     * @return the current direction
     */
    public String getDirection() {
        System.setOut(printStream);
        outputStream.reset();
        showState("");

        String state = outputStream.toString().trim();
        int startIndex = state.indexOf("direction: ") + 11;
        int parenthesisIndex = state.indexOf(")", startIndex);

        String direction = state.substring(startIndex, parenthesisIndex);
        System.setOut(originalOut);
        return direction;
    }
}
