package com.alice;

import java.util.function.Supplier;

import io.vavr.Function1;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Queue;
import io.vavr.control.Option;

/**
 * Implements a simple breadth first search algorithm
 */
public class BreadthSearch extends TreeSearcher {

    BreadthSearch(int searchFor, Node root) {
        super(searchFor, root);
    }

    @Override
    protected Function1<List<Node>, List<Node>> getF(List<Node> nodes) {
        return (l) -> l.appendAll(nodes);
    }
   
    
}
