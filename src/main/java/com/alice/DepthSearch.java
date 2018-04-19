package com.alice;


import java.util.Optional;

/**
 * Searches for a node that holds a given value.
 * WARN: Returns the first node that holds the value.
 */
public class DepthSearch extends TreeSearcher {

    DepthSearch(Integer searchFor, Optional<Node> root) {
        super(searchFor, root);
    }

    /**
     * Do the actual search
     *
     * @param currentNode is the current node being checked
     * @return the found node or Optional.empty if none
     */
    private Optional<Node> doSearch(Optional<Node> currentNode) {
        System.out.println("Looking at the following node " + currentNode);

        return currentNode.flatMap(node -> {
            if (node.getValue() == this.searchFor) {
                return Optional.of(node);
            }

            return Optional.ofNullable(doSearch(node.getLeft()).orElse(doSearch(node.getRight()).orElse(null)));

        });

    }

    @Override
    public Optional<Node> search() {
        System.out.println("Looking for value: " + this.searchFor);
        return this.doSearch(this.root);
    }
}
