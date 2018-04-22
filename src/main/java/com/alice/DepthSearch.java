package com.alice;

import io.vavr.Function1;
import io.vavr.collection.List;

class DepthSearch extends TreeSearcher {

    DepthSearch(int searchFor, Node root) {
        super(searchFor, root);
    }

    @Override
    protected Function1<List<Node>, List<Node>> getF(List<Node> nodes) {
        return (l) -> l.prependAll(nodes);
    }

}