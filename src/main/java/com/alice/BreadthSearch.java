package com.alice;


import java.util.function.Predicate;
import java.util.function.Supplier;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.collection.List;
import io.vavr.control.Option;

/**
 * Implements a simple breadth first search algorithm
 */
public class BreadthSearch extends TreeSearcher {

    BreadthSearch(Integer searchFor, Node root) {
        super(searchFor, root);
    }

    private Supplier<Option<Node>> checkChildren(List<Node> nodes) {
        List<Node> children = nodes.flatMap(Node::getLeft).appendAll(nodes.flatMap(Node::getRight));
        return () -> children.isEmpty() ? Option.none() : doSearch(children);
        // return () -> doSearch(nodes.flatMap(Node::getLeft).appendAll(nodes.flatMap(Node::getRight)));
    }
    
    /**
     * Do the actual search
     * @param nodes the list of nodes at the same level to be searched
     * @return the Optional node if found or empty
     */
    private Option<Node> doSearch(List<Node> nodes) {

        System.out.println("Looking at the following nodes: " + nodes);
        return nodes.filter(isSerachFor()).toOption().orElse(checkChildren(nodes));
      
    }


    @Override
    public Option<Node> search() {
        System.out.println("Breadth Started... Looking for value : " + this.searchFor);
        return this.doSearch(List.of(this.root));
    }
}
