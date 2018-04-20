package com.alice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.vavr.control.Option;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepthSearchTest {

    private static Node root;

    @BeforeAll
    static void setupRoot() {
        Node root = new Node(50);
        Node right1 = root.setToLeft(25);
        root.setToRight(75);

        right1.setToRight(3);
        right1.setToLeft(34);

        DepthSearchTest.root = root;

    }

    @AfterAll
    static void flush() {
        System.out.flush();
    }

    @Test
    @DisplayName("Find value 3 on the tree")
    void findDeepTest() {
        TreeSearcher searcher = new DepthSearch(3, root);
        Option<Node> found = searcher.search();
        assertEquals(3, found.get().getValue());
    }

    @Test
    @DisplayName("Find empty node while looking for 1 on the tree")
    void findEmpty() {
        TreeSearcher searcher = new DepthSearch(1, root);
        assertEquals(Option.none(), searcher.search());
    }
}
