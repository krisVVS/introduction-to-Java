package com.onto.javacourse.objectsinjava.homogeneoustree;

import java.util.ArrayList;
import java.util.List;

class HomogeneousTree<T> {
    private T value;
    private String name;
    private List<HomogeneousTree<T>> children;

    public HomogeneousTree(T value, String name) {
        this.value = value;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void addChild(HomogeneousTree<T> child) {
        this.children.add(child);
    }

    public void printTree(String prefix) {
        System.out.println(prefix + name + " (" + value + ")");
        for (HomogeneousTree<T> child : children) {
            child.printTree(prefix + "-");
        }
    }
    public static void main(String[] args) {
        HomogeneousTree<Integer> root = new HomogeneousTree<>(1, "Root");
        HomogeneousTree<Integer> child1 = new HomogeneousTree<>(2, "Child 1");
        HomogeneousTree<Integer> child2 = new HomogeneousTree<>(3, "Child 2");

        root.addChild(child1);
        root.addChild(child2);

        child1.addChild(new HomogeneousTree<>(4, "Child 1.1"));
        child1.addChild(new HomogeneousTree<>(5, "Child 1.2"));

        child2.addChild(new HomogeneousTree<>(6, "Child 2.1"));

        root.printTree(""); // Print the tree structure
    }
}