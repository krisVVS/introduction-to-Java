package com.onto.javacourse.objectsinjava.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BinarySearchTreeTest {

  private BinarySearchTree bst;

  @BeforeEach
  void setUp() {
    bst = new BinarySearchTree();
  }

  @Test
  void testInsertAndPrint() {
    bst.insert(new Node(5));
    bst.insert(new Node(3));
    bst.insert(new Node(7));
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.print();
    String expectedOutput = "3 5 7 ";
    assertEquals(expectedOutput, outContent.toString());
    System.setOut(System.out);
  }

  @Test
  void testSearch() {
    bst.insert(new Node(5));
    bst.insert(new Node(3));
    bst.insert(new Node(7));
    assertTrue(bst.search(5));
    assertTrue(bst.search(3));
    assertTrue(bst.search(7));
    assertFalse(bst.search(4));
    assertFalse(bst.search(10));
  }

  @Test
  void testInsertDuplicate() {
    bst.insert(new Node(5));
    bst.insert(new Node(3));
    bst.insert(new Node(7));
    bst.insert(new Node(5));
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.print();
    String expectedOutput = "3 5 7 ";
    assertEquals(expectedOutput, outContent.toString());
    System.setOut(System.out);
  }
}
