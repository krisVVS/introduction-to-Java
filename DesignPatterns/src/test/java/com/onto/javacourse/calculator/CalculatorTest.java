package com.onto.javacourse.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @Test
  public void testAdd() {
    Command addCommand = new AddCommand(calculator, 5, 3);
    assertEquals(8, addCommand.execute());
  }

  @Test
  public void testSubtract() {
    Command subtractCommand = new SubtractCommand(calculator, 5, 3);
    assertEquals(2, subtractCommand.execute());
  }

  @Test
  public void testMultiply() {
    Command multiplyCommand = new MultiplyCommand(calculator, 5, 3);
    assertEquals(15, multiplyCommand.execute());
  }

  @Test
  public void testDivide() {
    Command divideCommand = new DivideCommand(calculator, 6, 3);
    assertEquals(2, divideCommand.execute());
  }

  @Test
  public void testDivideByZero() {
    Command divideCommand = new DivideCommand(calculator, 6, 0);
    assertThrows(ArithmeticException.class, divideCommand::execute);
  }

  @Test
  public void testPower() {
    Command powerCommand = new PowerCommand(calculator, 2, 3);
    assertEquals(8, powerCommand.execute());
  }
}
