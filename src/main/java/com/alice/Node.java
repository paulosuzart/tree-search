package com.alice;

import io.vavr.control.Option;

/**
 * Represents a node in a tree
 */
public class Node {

	/**
     * The value te node holds itself
     */
    private int value;

    /**
     * A Option pointer to a right node down below
     */
    private Option<Node> right = Option.none();

    /**
     * A Option pointer to a left node down below
     */
    private Option<Node> left = Option.none();

    Node(Integer value) {
        this.value = value;
    }

    @SuppressWarnings("unused")
    Node(Integer value, Option<Node> left, Option<Node> right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    @SuppressWarnings("unused")
    Node(Integer value, Option<Node> left) {
        this.value = value;
        this.right = left;
    }

    public Node setToLeft(Integer value) {
        Node newNode = new Node(value);
        this.left = Option.of(newNode);
        return newNode;
    }

    public Node setToRight(Integer value) {
        Node newNode = new Node(value);
        this.right = Option.of(newNode);
        return newNode;
    }


    public int getValue() {
        return this.value;
    }

    public Option<Node> getRight() {
        return right;
    }

    public Option<Node> getLeft() {
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
