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
     * @param currentNode
     * @return the found node or Optional.empty if none
     */
    private Optional<Node> doSearch(Optional<Node> currentNode) {
        System.out.println("Looking at the following node " + currentNode);
        Optional<Node> found = currentNode.flatMap(node -> {
            if (node.getValue().equals(this.searchFor)) {
                return Optional.of(node);
            }

            Optional<Node> foundLeft = doSearch(node.getLeft());

            Node foundRight = foundLeft.orElse(doSearch(node.getRight()).orElse(null));

            return Optional.ofNullable(foundRight);

        });

        return found;
    }

    @Override
    public Optional<Node> search() {

        return this.doSearch(this.root);
    }
}
