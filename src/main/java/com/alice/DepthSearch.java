package com.alice;

import java.util.function.Supplier;

import io.vavr.control.Option;

class DepthSearch extends TreeSearcher {

    DepthSearch(int searchFor, Node root) {
        super(searchFor, root);
    }

    private Supplier<Option<Node>> checkChildren(Option<Node> node) {
        return () -> node.flatMap(n -> doSearch(n.getLeft()).orElse(doSearch(n.getRight())));
    }

    private Option<Node> doSearch(Option<Node> currentNode) {

        System.out.println("Looking at the following node " + currentNode);
        return currentNode.filter(isSerachFor()).orElse(checkChildren(currentNode));
    }

    @Override
    public Option<Node> search() {
        System.out.println("Depth started... Looking for " + this.searchFor);
        return this.doSearch(Option.some(this.root));
    }

}