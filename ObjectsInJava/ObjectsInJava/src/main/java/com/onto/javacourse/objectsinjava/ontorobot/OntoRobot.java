package com.onto.javacourse.objectsinjava.ontorobot;
import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import kareltherobot.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OntoRobot extends UrRobot {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outputStream);
    private PrintStream originalOut = System.out;

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

    public int getStreet() {
        System.setOut(printStream);

        outputStream.reset();

        showState("");
        String state = outputStream.toString().trim();

        int street = 0;
        int startIndex = state.indexOf("street: ") + 8;
        int ParenthesisIndex = state.indexOf(")", startIndex);  // Index after the "beepers" part

        street = Integer.parseInt(state.substring(startIndex, ParenthesisIndex));
        System.setOut(originalOut);
        return street;
    }

    public int getAvenue() {
        System.setOut(printStream);

        outputStream.reset();

        showState("");
        String state = outputStream.toString().trim();

        int avenue = 0;
        int startIndex = state.indexOf("avenue: ") + 8;
        int ParenthesisIndex = state.indexOf(")", startIndex);  // Index after the "beepers" part

        avenue = Integer.parseInt(state.substring(startIndex, ParenthesisIndex));
        System.setOut(originalOut);
        return avenue;
    }

    public int getBeepersCount() {
        System.setOut(printStream);

        outputStream.reset();

        showState("");
        String state = outputStream.toString().trim();

        int beepersCount = 0;
        int startIndex = state.indexOf("beepers: ") + 9;
        int ParenthesisIndex = state.indexOf(")", startIndex);  // Index after the "beepers" part

        beepersCount = Integer.parseInt(state.substring(startIndex, ParenthesisIndex));
        System.setOut(originalOut);
        return beepersCount;
    }

    public String getDirection() {
        System.setOut(printStream);

        outputStream.reset();

        showState("");
        String state = outputStream.toString().trim();

        String Direction = "";
        int startIndex = state.indexOf("direction: ") + 11;
        int ParenthesisIndex = state.indexOf(")", startIndex);  // Index after the "beepers" part

        Direction = state.substring(startIndex, ParenthesisIndex);
        System.setOut(originalOut);
        return Direction;
    }



}