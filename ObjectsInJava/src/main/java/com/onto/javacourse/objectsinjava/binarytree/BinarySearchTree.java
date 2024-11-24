package com.onto.javacourse.objectsinjava.binarytree;

/** A basic implementation of a Binary Search Tree (BST). */
public class BinarySearchTree {
  Node root;

  /**
   * Inserts a new node into the binary search tree.
   *
   * @param node The node to insert.
   */
  public void insert(Node node) {
    root = insertHelper(root, node);
  }

  /**
   * Helper method to recursively insert a node into the tree.
   *
   * @param temporaryRoot The current root of the subtree.
   * @param node The node to insert.
   * @return The updated subtree root.
   */
  private Node insertHelper(Node temporaryRoot, Node node) {
    int value = node.value;

    if (temporaryRoot == null) {
      temporaryRoot = node;
      return temporaryRoot;
    } else if (value < temporaryRoot.value) {
      temporaryRoot.left = insertHelper(temporaryRoot.left, node);
    } else if (value > temporaryRoot.value) {
      temporaryRoot.right = insertHelper(temporaryRoot.right, node);
    }
    return temporaryRoot;
  }

  /** Prints the values of the nodes in the tree in sorted order. */
  public void print() {
    printHelper(root);
  }

  /**
   * Helper method to recursively print the nodes of the tree in-order.
   *
   * @param root The root of the current subtree.
   */
  private void printHelper(Node root) {
    if (root != null) {
      printHelper(root.left);
      System.out.print(root.value + " ");
      printHelper(root.right);
    }
  }

  /**
   * Searches for a value in the binary search tree.
   *
   * @param value The value to search for.
   * @return True if the value is found, false otherwise.
   */
  public boolean search(int value) {
    return searchHelper(root, value);
  }

  /**
   * Helper method to recursively search for a value in the tree.
   *
   * @param temporarySearchRoot The current root of the subtree.
   * @param value The value to search for.
   * @return True if the value is found, false otherwise.
   */
  private boolean searchHelper(Node temporarySearchRoot, int value) {
    if (temporarySearchRoot == null) {
      return false;
    } else if (temporarySearchRoot.value == value) {
      return true;
    } else if (temporarySearchRoot.value > value) {
      return searchHelper(temporarySearchRoot.left, value);
    } else {
      return searchHelper(temporarySearchRoot.right, value);
    }
  }
}
