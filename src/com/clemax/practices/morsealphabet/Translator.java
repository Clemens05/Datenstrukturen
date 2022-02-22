package com.clemax.practices.morsealphabet;

import com.clemax.BinaryTree;

public class Translator {
    private BinaryTree<Character> morseTree;

    public Translator() {
        /*
        morseTree = new BinaryTree<>(
                ' ',
                new BinaryTree<>(
                        'E',
                        new BinaryTree<>(
                                'I',
                                new BinaryTree<>(
                                        'S',
                                        new BinaryTree<>(
                                                'H'
                                        ),
                                        new BinaryTree<>(
                                                'V'
                                        )
                                ),
                                new BinaryTree<>(
                                        'U',
                                        new BinaryTree<>(
                                                'F'
                                        ),
                                        new BinaryTree<>(
                                                ' '
                                        )
                                )
                        ),
                        new BinaryTree<>(
                                'A',
                                new BinaryTree<>(
                                        'R',
                                        new BinaryTree<>(
                                                'L'
                                        ),
                                        new BinaryTree<>(
                                                ' '
                                        )
                                ),
                                new BinaryTree<>(
                                        'W',
                                        new BinaryTree<>(
                                                'P'
                                        ),
                                        new BinaryTree<>(
                                                'J'
                                        )
                                )
                        )
                ),
                new BinaryTree<>(
                        'T',
                        new BinaryTree<>(
                                'N',
                                new BinaryTree<>(
                                        'D',
                                        new BinaryTree<>(
                                                'B'
                                        ),
                                        new BinaryTree<>(
                                                'X'
                                        )
                                ),
                                new BinaryTree<>(
                                        'K',
                                        new BinaryTree<>(
                                                'C'
                                        ),
                                        new BinaryTree<>(
                                                'Y'
                                        )
                                )
                        ),
                        new BinaryTree<>(
                                'M',
                                new BinaryTree<>(
                                        'G',
                                        new BinaryTree<>(
                                                'Z'
                                        ),
                                        new BinaryTree<>(
                                                'Q'
                                        )
                                ),
                                new BinaryTree<>(
                                        'O'
                                )
                        )
                )
        );
        */

        morseTree = new BinaryTree<>();
        zeicheneinfuegen("", 'A', morseTree);
    }

    public String toMorse(String text) {
        char[] chars = text.toCharArray();

        for (char c: chars) {
            System.out.println(c);
        }

        return "";
    }

    public void getCharByTree(BinaryTree<Character> tree, char c) {
        if (tree.getLeftTree() != null) {
            inOrder(tree.getLeftTree());
        }
        System.out.println(tree.getContent());
        if (tree.getRightTree() != null) {
            inOrder(tree.getRightTree());
        }
    }

    public void inOrder(BinaryTree<Character> b) {
        if (b.getLeftTree() != null) {
            inOrder(b.getLeftTree());
        }
        System.out.println(b.getContent());
        if (b.getRightTree() != null) {
            inOrder(b.getRightTree());
        }
    }

    public BinaryTree<Character> getMorseTree() {
        return morseTree;
    }

    public BinaryTree<Character> zeicheneinfuegen(String morseCode, char zeichen, BinaryTree<Character> tree) {
        if (tree.isEmpty()) {
            tree = new BinaryTree<>(zeichen);
        }
        if (morseCode.isEmpty()) {
            tree.setContent(zeichen);
            return tree;
        } else if (morseCode.charAt(0) == '.') {
            tree.setLeftTree(zeicheneinfuegen(morseCode.substring(1), zeichen, tree.getLeftTree()));
        } else {
            tree.setRightTree(zeicheneinfuegen(morseCode.substring(1), zeichen, tree.getRightTree()));
        }
        return tree;
    }
}
