package org.bst;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();

        binaryTree.insert(41);
        binaryTree.insert(47);
        binaryTree.insert(50);
        binaryTree.insert(58);
        exercise001(binaryTree);
        exercise002(binaryTree);
        exercise003(binaryTree);
        exercise004(binaryTree);
        exercise005(binaryTree);
    }

    private static void exercise005(BinarySearchTree binaryTree) {
        System.out.print("\n\nDeleting 50 from BST");
        binaryTree.deleteNode(50);
        System.out.print("\n\nInOrder sort of BST after delete: ");
        binaryTree.inorder();
    }

    private static void exercise004(BinarySearchTree binaryTree) {
        System.out.print("\n\nPredeccessor of 47: " + binaryTree.findPredecessor(binaryTree.search(47)));
        System.out.print("\n\nSuccessor of 47: " + binaryTree.findSuccessor(binaryTree.search(47)));
    }

    private static void exercise003(BinarySearchTree binaryTree) {
        System.out.print("\n\nHeight of BST: " + binaryTree.getHeight());
    }

    private static void exercise002(BinarySearchTree binaryTree) {
        System.out.print("\n\nMin value in BST: " + binaryTree.getMinNode());
        System.out.print("\n\nMax value in BST: " + binaryTree.getMaxNode());
    }

    private static void exercise001(BinarySearchTree binaryTree) {
        System.out.print("\n\nPreOrder sort of BST: ");
        binaryTree.preOrder();
        System.out.print("\n\nPostOrder sort of BST: ");
        binaryTree.postOrder();
        System.out.print("\n\nInOrder sort of BST: ");
        binaryTree.inorder();
    }

}