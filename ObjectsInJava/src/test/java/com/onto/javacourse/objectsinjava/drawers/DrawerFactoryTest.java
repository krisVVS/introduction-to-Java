package com.onto.javacourse.objectsinjava.drawers;

import com.onto.javacourse.objectsinjava.hierachyoffigures.*;
import com.onto.javacourse.objectsinjava.interfaces.Drawer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawerFactoryTest {

  @Test
  void testGetDrawerForPoint() {
    Point point = new Point(1, 1);
    Drawer<Point> drawer = DrawerFactory.getDrawer(point);
    assertNotNull(drawer);
    assertTrue(drawer instanceof DrawerPoint);
  }

  @Test
  void testGetDrawerForLine() {
    Line line = new Line(new Point(1, 1), new Point(3, 3));
    Drawer<Line> drawer = DrawerFactory.getDrawer(line);
    assertNotNull(drawer);
    assertTrue(drawer instanceof DrawerLine);
  }

  @Test
  void testGetDrawerForRectangle() {
    Rectangle rectangle = new Rectangle(new Point(2, 2), 3, 2);
    Drawer<Rectangle> drawer = DrawerFactory.getDrawer(rectangle);
    assertNotNull(drawer);
    assertTrue(drawer instanceof DrawerRectangle);
  }

  @Test
  void testGetDrawerForSquare() {
    Square square = new Square(new Point(1, 1), 4);
    Drawer<Square> drawer = DrawerFactory.getDrawer(square);
    assertNotNull(drawer);
    assertTrue(drawer instanceof DrawerSquare);
  }

  @Test
  void testGetDrawerForUnsupportedFigure() {
    Figure unsupportedFigure = new Figure() {};
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              DrawerFactory.getDrawer(unsupportedFigure);
            });
    assertEquals("No drawer found for figure:", exception.getMessage().trim());
  }
}
