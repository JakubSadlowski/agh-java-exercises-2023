package org.bst;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() { root = null; }

    BinarySearchTree(int value) { root = new Node(value); }

    public void insert(int key) { root = insertRec(root, key); }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    public void inorder() { inOrderRecursionPrint(root); }

     private void inOrderRecursionPrint(Node root) {
        if (root != null) {
            inOrderRecursionPrint(root.left);
            System.out.print(root.key + " ");
            inOrderRecursionPrint(root.right);
        }
    }

    public void preOrder() { preOrderRecursionPrint(root); }

    private void preOrderRecursionPrint(Node root)
    {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRecursionPrint(root.left);
            preOrderRecursionPrint(root.right);
        }
    }

    public void postOrder() { postOrderRecursionPrint(root); }

    private void postOrderRecursionPrint(Node root)
    {
        if (root != null) {
            postOrderRecursionPrint(root.left);
            postOrderRecursionPrint(root.right);
            System.out.print(" " + root.key);
        }
    }

    public int getHeight() { return height(root); }

    private int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public int getMinNode() { return minValueNode(root); }

    private int minValueNode(Node node)
    {
        Node current = node;

        while (current != null && current.left != null)
            current = current.left;

        return current.key;
    }

    public int getMaxNode() { return maxValueNode(root); }

    private int maxValueNode(Node node)
    {
        Node current = node;

        while (current != null && current.right != null)
            current = current.right;

        return current.key;
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    public int findSuccessor(Node node) {
        if (node.right != null) {
            return minValueNode(node.right);
        }

        Node successor = null;
        Node current = root;
        while (current != null) {
            if (node.key < current.key) {
                successor = current;
                current = current.left;
            } else if (node.key > current.key) {
                current = current.right;
            } else {
                break;
            }
        }
        return successor.key;
    }

    public int findPredecessor(Node node) {
        if (node.left != null) {
            return maxValueNode(node.left);
        }

        Node predecessor = null;
        Node current = root;
        while (current != null) {
            if (node.key > current.key) {
                predecessor = current;
                current = current.right;
            } else if (node.key < current.key) {
                current = current.left;
            } else {
                break;
            }
        }
        return predecessor.key;
    }

    public void deleteNode(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (root.key > key) {
            root.left = delete(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = delete(root.right, key);
            return root;
        }

        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }
        else {
            Node succParent = root;
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            root.key = succ.key;
            return root;
        }
    }
}
