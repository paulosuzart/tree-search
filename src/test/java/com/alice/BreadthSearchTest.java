package com.alice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthSearchTest {

    private static Node root;

    @BeforeAll
    static void setupRoot() {
        Node root = new Node(50);
        Node left1 = root.setToLeft(25);
        Node right1 = root.setToRight(75);

        left1.setToLeft(20);
        left1.setToRight(35);

        right1.setToLeft(60);

        Node right3 = right1.setToRight(78);
        right3.setToRight(100);

        BreadthSearchTest.root = root;

    }

    @AfterAll
    static void flush() {
        System.out.flush();
    }

    @Test
    @DisplayName("Find value 3 on the tree")
    void findBreadthTest() {
        TreeSearcher searcher = new BreadthSearch(20, Optional.of(BreadthSearchTest.root));
        searcher.search().ifPresent(node -> assertEquals(new Integer(20), node.getValue()));
    }

    @Test
    @DisplayName("Find empty node while looking for 1 on the tree")
    void findEmpty() {
        TreeSearcher searcher = new BreadthSearch(1, Optional.of(BreadthSearchTest.root));
        searcher.search().ifPresent(node -> assertEquals(Optional.empty(), node));
    }

    @Test
    @DisplayName("Find value 3 on the tree")
    void findBreadthRightTest() {
        TreeSearcher searcher = new BreadthSearch(100, Optional.of(BreadthSearchTest.root));
        searcher.search().ifPresent(node -> assertEquals(new Integer(100), node.getValue()));
    }

}
