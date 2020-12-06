package com.games.BST;

public class BST {

    Node root;

    Node findInOrderSuccessor(Node inputNode) {
        if (inputNode.right != null) {
            return getLeftMost(inputNode.right);
        }
        Node in = inputNode;
        Node n = inputNode.parent;
        while (n != null && in == n.right) {
            in = n;
            n = n.parent;
        }
        return n;
    }

    private Node getLeftMost(Node node) {
        if (node.left == null)
            return node;
        return getLeftMost(node.left);
    }

    Node insert(Node node, int data) {

        if (node == null) {
            return (new Node(data));
        } else {

            Node temp = null;

            if (data <= node.key) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            return node;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.findInOrderSuccessor(temp);
        if (suc != null) {
            System.out.println(
                    "Inorder successor of "
                            + temp.key + " is " + suc.key);
        } else {
            System.out.println(
                    "Inorder successor does not exist");
        }
    }
}
