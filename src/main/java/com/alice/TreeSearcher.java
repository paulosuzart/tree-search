package com.alice;

import java.util.Optional;

/**
 * Abstract class to be implemented by search algorithms.
 */
public abstract class TreeSearcher {
    /**
     * The value the algorithm must look for
     */
    protected final Integer searchFor;

    /**
     * The root start node to start the search
     */
    protected final Optional<Node> root;

    TreeSearcher(Integer searchFor, Optional<Node> root) {
        this.searchFor = searchFor;
        this.root = root;
    }

    /**
     * Looks up for the node containing the {@code searchFor} value starting from {@code root} node
     *
     * @return
     */
    public abstract Optional<Node> search();
}
