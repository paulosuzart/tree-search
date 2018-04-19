package com.alice;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implements a simple breadth first search algorithm
 */
public class BreadthSearch extends TreeSearcher {

    BreadthSearch(Integer searchFor, Optional<Node> root) {
        super(searchFor, root);
    }

    /**
     * Do the actual search
     * @param nodes the list of nodes at the same level to be searched
     * @return the Optional node if found or empty
     */
    private Optional<Node> doSearch(List<Optional<Node>> nodes) {

        if (nodes.isEmpty()) {
            return Optional.empty();
        }

        System.out.println("Looking at the following nodes: " + nodes);
        List<Optional<Node>> nextSearchNodes = new ArrayList<>();


        for (final Optional<Node> node : nodes) {
            Optional<Node> found = node.filter(currentNode -> currentNode.getValue() == this.searchFor);

            if (found.isPresent()) {
                return found;
            }

            node.ifPresent(currentNode -> {
                if (currentNode.getLeft().isPresent()) {
                    nextSearchNodes.add(currentNode.getLeft());
                }
                if (currentNode.getRight().isPresent()) {
                    nextSearchNodes.add(currentNode.getRight());
                }
            });

        }

        return this.doSearch(nextSearchNodes);
    }


    @Override
    public Optional<Node> search() {
        List<Optional<Node>> seedNodes = new ArrayList<>();
        seedNodes.add(this.root);
        return this.doSearch(seedNodes);
    }
}
