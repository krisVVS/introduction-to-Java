package com.onto.javacourse.objectsinjava.homogeneoustree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HomogeneousTreeTest {
    private HomogeneousTree<Integer> root;
    private HomogeneousTree<Integer> child1;
    private HomogeneousTree<Integer> child2;
    private HomogeneousTree<Integer> grandchild;

    @BeforeEach
    void setUp() {
        root = new HomogeneousTree<>(10, "Root");
        child1 = new HomogeneousTree<>(20, "Child1");
        child2 = new HomogeneousTree<>(30, "Child2");
        grandchild = new HomogeneousTree<>(40, "Grandchild");
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandchild);
    }

    @Test
    void testGetValue() {
        assertEquals(10, root.getValue());
        assertEquals(20, child1.getValue());
        assertEquals(30, child2.getValue());
        assertEquals(40, grandchild.getValue());
    }

    @Test
    void testGetName() {
        assertEquals("Root", root.getName());
        assertEquals("Child1", child1.getName());
        assertEquals("Child2", child2.getName());
        assertEquals("Grandchild", grandchild.getName());
    }

    @Test
    void testAddChild() {
        HomogeneousTree<Integer> newChild = new HomogeneousTree<>(50, "NewChild");
        root.addChild(newChild);
        assertNotNull(root);
        List<HomogeneousTree<Integer>> children = new ArrayList<>(root.children);
        assertEquals(3, children.size());
        assertEquals(newChild, children.get(2));
    }

    @Test
    void testTreeStructure() {
        assertEquals(2, root.children.size());
        assertEquals(1, child1.children.size());
        assertEquals(0, child2.children.size());
        assertEquals(grandchild, child1.children.get(0));
    }

    @Test
    void testPrintTree() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        root.printTree("");
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "Root (10)" + lineSeparator +
                "-Child1 (20)" + lineSeparator +
                "--Grandchild (40)" + lineSeparator +
                "-Child2 (30)" + lineSeparator;
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);
        System.setOut(System.out);
    }
}