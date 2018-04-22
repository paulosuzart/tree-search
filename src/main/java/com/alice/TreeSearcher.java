package com.alice;

import java.util.Objects;
import java.util.function.Predicate;

import io.vavr.Function1;
import io.vavr.Tuple2;
import io.vavr.collection.List;
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
    
    protected abstract Function1<List<Node>, List<Node>> getF(List<Node> nodes);

    /**
     * Looks up for the node containing the {@code searchFor} value starting from {@code root} node
     *
     * @return
     */
    public Option<Node> search() {
        
        System.out.println("Breadth Started... Looking for value : " + this.searchFor);

        List<Node> toSearch = List.of(this.root);

        while (!toSearch.isEmpty()) {
            final Tuple2<Node, List<Node>> headAndTail = toSearch.pop2();
            
            final Node currentNode = headAndTail._1;
            toSearch = headAndTail._2;

            if (currentNode.getValue() == this.searchFor) {
                return Option.some(currentNode);
            }

            List<Node> nextNodes = List.of(currentNode.getLeft(), currentNode.getRight()).flatMap(n -> n);
            toSearch = getF(toSearch).apply(nextNodes);
        }

        return Option.none();
    }
}
