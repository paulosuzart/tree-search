package com.alice;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Implements a simple breadth first search algorithm
 */
public class BreadthSearch extends TreeSearcher {

    BreadthSearch(Integer searchFor, Node root) {
        super(searchFor, root);
    }

    private static Consumer<Node> enqueue(final List<Node> list) {
        return n -> list.add(n);
    }

    /**
     * Do the actual search
     * @param nodes the list of nodes at the same level to be searched
     * @return the Optional node if found or empty
     */
    private Optional<Node> doSearch(List<Node> nodes) {

        if (nodes.isEmpty()) {
            return Optional.empty();
        }

        System.out.println("Looking at the following nodes: " + nodes);
        List<Node> nextSearchNodes = new ArrayList<>();


        for (final Node node : nodes) {
            
            if (node.getValue() == this.searchFor) {
                return Optional.of(node);
            }
            
            node.getLeft().ifPresent(enqueue(nextSearchNodes));
            node.getRight().ifPresent(enqueue(nextSearchNodes));

        }

        return this.doSearch(nextSearchNodes);
    }


    @Override
    public Optional<Node> search() {
        List<Node> seedNodes = new ArrayList<>();
        seedNodes.add(this.root);
        return this.doSearch(seedNodes);
    }
}
