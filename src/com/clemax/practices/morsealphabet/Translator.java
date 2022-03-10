package com.clemax.practices.morsealphabet;

import com.clemax.BinaryTree;

import java.util.Locale;

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
        morseTree = zeicheneinfuegen(".-", 'A', morseTree);
        morseTree = zeicheneinfuegen("-...", 'B', morseTree);
        morseTree = zeicheneinfuegen("-.-.", 'C', morseTree);
        morseTree = zeicheneinfuegen("-..", 'D', morseTree);
        morseTree = zeicheneinfuegen(".", 'E', morseTree);
        morseTree = zeicheneinfuegen("..-.", 'F', morseTree);
        morseTree = zeicheneinfuegen("--.", 'G', morseTree);
        morseTree = zeicheneinfuegen("....", 'H', morseTree);
        morseTree = zeicheneinfuegen("..", 'I', morseTree);
        morseTree = zeicheneinfuegen(".---", 'J', morseTree);
        morseTree = zeicheneinfuegen("-.-", 'K', morseTree);
        morseTree = zeicheneinfuegen(".-..", 'L', morseTree);
        morseTree = zeicheneinfuegen("--", 'M', morseTree);
        morseTree = zeicheneinfuegen("-.", 'N', morseTree);
        morseTree = zeicheneinfuegen("---", 'O', morseTree);
        morseTree = zeicheneinfuegen(".--.", 'P', morseTree);
        morseTree = zeicheneinfuegen("--.-", 'Q', morseTree);
        morseTree = zeicheneinfuegen(".-.", 'R', morseTree);
        morseTree = zeicheneinfuegen("...", 'S', morseTree);
        morseTree = zeicheneinfuegen("-", 'T', morseTree);
        morseTree = zeicheneinfuegen("..-", 'U', morseTree);
        morseTree = zeicheneinfuegen("...-", 'V', morseTree);
        morseTree = zeicheneinfuegen(".--", 'W', morseTree);
        morseTree = zeicheneinfuegen("-..-", 'X', morseTree);
        morseTree = zeicheneinfuegen("-.--", 'Y', morseTree);
        morseTree = zeicheneinfuegen("--..", 'Z', morseTree);
        morseTree.setContent(' ');
    }

    public String codieren(String text) {
        text = text.toUpperCase(Locale.ROOT);
        String morsecode = "";

        for (int i = 0; i < text.length(); i++) {
            morsecode += zeichenCodieren(text.charAt(i), morseTree, "") + ((text.length() == i + 1) ? "" : "/");
        }

        return morsecode;
    }

    private String zeichenCodieren(char zeichen, BinaryTree<Character> tree, String morsecode) {
        String text;

        if (tree.isEmpty()) {
            return "";
        } else {
            if (tree.getContent() == zeichen) {
                text = morsecode;
            } else {
                text = zeichenCodieren(zeichen, tree.getLeftTree(), morsecode + ".") +
                        zeichenCodieren(zeichen, tree.getRightTree(), morsecode + "-");
            }
        }

        return text;
    }

    public String decodieren(String morsecode) {
        if (!morsecode.endsWith("/")) {
            morsecode += "/";
        }

        String text = "";
        String teilMorsecode = "";

        for (int i = 0; i < morsecode.length(); i++) {
            switch (morsecode.charAt(i)) {
                case '.' -> teilMorsecode += '.';
                case '-' -> teilMorsecode += '-';
                case '/' -> {
                    text += zeichenDecodieren(teilMorsecode);
                    teilMorsecode = "";
                }
                default -> System.err.println("Der Morsecode darf nur '.', '-' und '/' Symbole enthalten");
            }
        }

        return text;
    }

    private char zeichenDecodieren(String morsecode) {
        BinaryTree<Character> currentTree = this.morseTree;

        for (int i = 0; i < morsecode.length(); i++) {
            if (morsecode.charAt(i) == '.') {
                currentTree = currentTree.getLeftTree();
            } else if (morsecode.charAt(i) == '-') {
                currentTree = currentTree.getRightTree();
            }
        }

        return currentTree.getContent();
    }

    public void inOrder(BinaryTree<Character> b) {
        if (b == null) return;

        inOrder(b.getLeftTree());

        System.out.println(b.getContent() + " ");

        inOrder(b.getLeftTree());
    }

    public BinaryTree<Character> getMorseTree() {
        return morseTree;
    }

    private BinaryTree<Character> zeicheneinfuegen(String morseCode, char zeichen, BinaryTree<Character> tree) {
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
