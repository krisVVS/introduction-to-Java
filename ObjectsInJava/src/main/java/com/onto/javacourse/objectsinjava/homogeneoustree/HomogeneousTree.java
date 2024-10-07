package com.onto.javacourse.objectsinjava.homogeneoustree;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple tree structure where each node can have multiple children of the same type.
 *
 * @param <T> The type of value stored in each node.
 */
class HomogeneousTree<T> {
    private T value;
    private String name;
    public List<HomogeneousTree<T>> children;

    /**
     * Creates a new tree node with a given value and name.
     *
     * @param value The value stored in this node.
     * @param name  The name of this node.
     */
    public HomogeneousTree(T value, String name) {
        this.value = value;
        this.name = name;
        this.children = new ArrayList<>();
    }

    /**
     * Gets the value of this node.
     *
     * @return The value stored in the node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets the name of this node.
     *
     * @return The name of the node.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a child node to this node.
     *
     * @param child The child node to add.
     */
    public void addChild(HomogeneousTree<T> child) {
        children.add(child);
    }

    /**
     * Prints the tree structure starting from this node.
     *
     * @param prefix The prefix to show the tree level.
     */
    public void printTree(String prefix) {
        System.out.println(prefix + name + " (" + value + ")");
        for (HomogeneousTree<T> child : children) {
            child.printTree(prefix + "-");
        }
    }
}
