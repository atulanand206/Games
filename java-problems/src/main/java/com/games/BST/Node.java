package com.games.BST;

public class Node {

    int key;
    Node left;
    Node right;
    Node parent;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
