package com.alice;

import java.util.Objects;
import java.util.function.Predicate;

import io.vavr.control.Option;

/**
 * Abstract class to be implemented by search algorithms.
 */
public abstract class TreeSearcher {
    /**
     * The value the algorithm must look for
     */
    protected final int searchFor;

    /**
     * The root start node to start the search
     */
    protected final Node root;

    TreeSearcher(int searchFor, Node root) {
        this.searchFor = searchFor;
        this.root = Objects.requireNonNull(root);
    }

    protected Predicate<Node> isSerachFor() {
        return n -> n.getValue() == this.searchFor;
    }

    /**
     * Looks up for the node containing the {@code searchFor} value starting from {@code root} node
     *
     * @return
     */
    public abstract Option<Node> search();
}
