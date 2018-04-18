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
     * Do the actual serach
     * @param nodes
     * @return the Optional node if found or empy
     */
    private Optional<Node> doSearch(List<Optional<Node>> nodes) {

        if (nodes.isEmpty()) {
            return Optional.empty();
        }

        System.out.println("Looking at the following nodes: " + nodes);
        List<Optional<Node>> nextSearchNodes = new ArrayList<>();


        for (final Optional<Node> node : nodes) {
            Optional<Node> found = node.filter(currentNode -> currentNode.getValue().equals(this.searchFor));

            if (found.isPresent()) {
                return found;
            }

            node.ifPresent(currentNode -> {
                nextSearchNodes.add(currentNode.getLeft());
                nextSearchNodes.add(currentNode.getRight());
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
