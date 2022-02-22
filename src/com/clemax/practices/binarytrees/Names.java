package com.clemax.practices.binarytrees;

import com.clemax.BinaryTree;

public class Names {
    private static String print;

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(
                10,
                new BinaryTree<>(
                        5,
                        new BinaryTree<>(
                                2
                        ),
                        new BinaryTree<>(
                                9
                        )
                ),
                new BinaryTree<>(
                        15,
                        new BinaryTree<>(
                                6
                        ),
                        new BinaryTree<>(
                                18
                        )
                )
        );

        preorder_durchlauf(tree);
        System.out.println(print);
    }

    public static void preorder_durchlauf(BinaryTree<Integer> tree) {
        if (!tree.isEmpty()) {
            print += tree.getContent() + ", ";
            System.out.println(tree.getContent());
            preorder_durchlauf(tree.getLeftTree());
            preorder_durchlauf(tree.getRightTree());
        }
    }
}
