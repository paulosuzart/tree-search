package com.alice;


import java.io.Serializable;
import java.util.Optional;

/**
 * Represents a node in a tree
 */
public class Node implements Serializable {

    /**
     * The value te node holds itself
     */
    private int value;

    /**
     * A optional pointer to a right node down below
     */
    private Optional<Node> right = Optional.empty();

    /**
     * A optional pointer to a left node down below
     */
    private Optional<Node> left = Optional.empty();

    Node(Integer value) {
        this.value = value;
    }

    @SuppressWarnings("unused")
    Node(Integer value, Optional<Node> left, Optional<Node> right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    @SuppressWarnings("unused")
    Node(Integer value, Optional<Node> left) {
        this.value = value;
        this.right = left;
    }

    public Node setToLeft(Integer value) {
        Node newNode = new Node(value);
        this.left = Optional.of(newNode);
        return newNode;
    }

    public Node setToRight(Integer value) {
        Node newNode = new Node(value);
        this.right = Optional.of(newNode);
        return newNode;
    }


    public int getValue() {
        return this.value;
    }

    public Optional<Node> getRight() {
        return right;
    }

    public Optional<Node> getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", id = " + System.identityHashCode(this) +
                '}';
    }
}
