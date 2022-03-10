package com.clemax;

public class BinarySearchTree<ContentType extends ComparableContent<ContentType>> {
    private class BinaryNode<ContentType extends ComparableContent<ContentType>> {
        private final ContentType content;
        private BinarySearchTree<ContentType> leftTree, rightTree;

        public BinaryNode(ContentType content) {
            this.content = content;
            this.leftTree = new BinarySearchTree<ContentType>();
            this.rightTree = new BinarySearchTree<ContentType>();
        }
    }
}
