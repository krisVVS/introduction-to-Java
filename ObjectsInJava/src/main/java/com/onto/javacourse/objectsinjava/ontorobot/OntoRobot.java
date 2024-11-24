package com.onto.javacourse.objectsinjava.ontorobot;

import static com.onto.javacourse.objectsinjava.directionconstants.DirectionConstants.EAST;
import static com.onto.javacourse.objectsinjava.directionconstants.DirectionConstants.NORTH;
import static com.onto.javacourse.objectsinjava.directionconstants.DirectionConstants.SOUTH;
import static com.onto.javacourse.objectsinjava.directionconstants.DirectionConstants.WEST;

import com.onto.javacourse.objectsinjava.drawers.DrawerFactory;
import com.onto.javacourse.objectsinjava.hierachyoffigures.Figure;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import kareltherobot.UrRobot;

/**
 * Represents an OntoRobot that extends the functionality of UrRobot. This robot can move, turn, and
 * draw figures on a grid.
 */
public class OntoRobot extends UrRobot {
  private int street;
  private int avenue;
  private int beepers;
  private String direction;

  /**
   * Constructs an OntoRobot at the specified street and avenue.
   *
   * @param street the initial street position of the robot.
   * @param avenue the initial avenue position of the robot.
   * @param direction the initial direction the robot is facing.
   * @param beepers the number of beepers the robot has.
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

  /** Turns the robot to the right. */
  public void turningRight() {
    turnLeft();
    turnLeft();
    turnLeft();
    switch (direction) {
      case EAST -> direction = "South";
      case SOUTH -> direction = "West";
      case WEST -> direction = "North";
      case NORTH -> direction = "East";
      default -> {
        // No action needed
      }
    }
  }

  /** Turns the robot to the left. */
  public void turningLeft() {
    turnLeft();
    switch (direction) {
      case EAST -> direction = "North";
      case SOUTH -> direction = "East";
      case WEST -> direction = "South";
      case NORTH -> direction = "West";
      default -> {
        // No action needed
      }
    }
  }

  /** Moves the robot one step forward in the current direction. */
  public void forward() {
    move();
    switch (direction) {
      case EAST -> avenue += 1;
      case SOUTH -> street -= 1;
      case WEST -> avenue -= 1;
      case NORTH -> street += 1;
      default -> {
        // No action needed
      }
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
    } else if (street < this.street) {
      turnToDirection("South");
    }
    moveSteps(Math.abs(this.street - street));

    if (avenue > this.avenue) {
      turnToDirection("East");
    } else if (avenue < this.avenue) {
      turnToDirection("West");
    }
    moveSteps(Math.abs(this.avenue - avenue));
  }

  /**
   * Turns the robot to the desired direction.
   *
   * @param desiredDirection the direction to turn to.
   */
  public void turnToDirection(String desiredDirection) {
    switch (direction) {
      case NORTH -> {
        switch (desiredDirection) {
          case EAST -> turningRight();
          case SOUTH -> {
            turningLeft();
            turningLeft();
          }
          case WEST -> turningLeft();
          default -> {
            // No action needed
          }
        }
      }
      case EAST -> {
        switch (desiredDirection) {
          case SOUTH -> turningRight();
          case WEST -> {
            turningLeft();
            turningLeft();
          }
          case NORTH -> turningLeft();
          default -> {
            // No action needed
          }
        }
      }
      case SOUTH -> {
        switch (desiredDirection) {
          case WEST -> turningRight();
          case NORTH -> {
            turningLeft();
            turningLeft();
          }
          case EAST -> turningLeft();
          default -> {
            // No action needed
          }
        }
      }
      case WEST -> {
        switch (desiredDirection) {
          case NORTH -> turningRight();
          case EAST -> {
            turningLeft();
            turningLeft();
          }
          case SOUTH -> turningLeft();
          default -> {
            // No action needed
          }
        }
      }
      default -> {
        // No action needed
      }
    }
    direction = desiredDirection;
  }

  private void moveSteps(int steps) {
    for (int i = 0; i < steps; i++) {
      forward();
    }
  }

  /** Places a beeper at the current position of the robot and decreases the beeper count. */
  public void puttingBeeper() {
    putBeeper();
    beepers -= 1;
  }

  /**
   * Draws the specified figure using the appropriate drawer.
   *
   * @param figure the figure to be drawn.
   * @param <T> the type of figure to be drawn.
   * @throws IllegalArgumentException if no drawer is found for the figure.
   */
  public <T extends Figure> void draw(T figure) {
    Drawer<T> drawer = DrawerFactory.getDrawer(figure);
    if (drawer != null) {
      drawer.draw(figure, this); // Draw the figure using the appropriate drawer
    } else {
      throw new IllegalArgumentException(
          "No drawer found for figure: " + figure.getClass().getSimpleName());
    }
  }
}
