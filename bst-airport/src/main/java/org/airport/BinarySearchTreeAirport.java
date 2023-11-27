package org.airport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeAirport {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTreeAirport() { root = null; }

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

    public void printLandingSchedule() {
        System.out.println("\n\nList of planned landings:");
        inOrderRecursionPrint(root);
    }

    private void inOrderRecursionPrint(Node root) {
        if (root != null) {
            inOrderRecursionPrint(root.left);
            System.out.print(root.key + " ");
            inOrderRecursionPrint(root.right);
        }
    }

    public void reserveLanding(int landingTime){
        if(checkLandingAvailability(root, landingTime)){
            insert(landingTime);
            System.out.print("\nReserved landing for " + landingTime);
        } else {
            System.out.print("\nCouldn't reserve landing for " + landingTime);
        }
    }

    private boolean checkLandingAvailability(Node root, int landingTime) {
        if (root == null) {
            return true;
        }

        if (landingTime <= root.key - 3 && landingTime != root.key) {
            return checkLandingAvailability(root.left, landingTime);
        } else if (landingTime >= root.key + 3 && landingTime != root.key) {
            return checkLandingAvailability(root.right, landingTime);
        } else {
            return false;
        }
    }

    private int getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.getSecond();
    }

    public void updateFlights() {
        int currentTime = getCurrentTime();
        List<Integer> landedFlights = new ArrayList<>();
        collectLandedFlights(root, currentTime, landedFlights);

        for (int landingTime : landedFlights) {
            System.out.println("\n\nLanding at time " + landingTime + " realized.");
            root = delete(root, landingTime);
        }
    }

    private void collectLandedFlights(Node root, int currentTime, List<Integer> landedFlights) {
        if (root == null) {
            return;
        }

        collectLandedFlights(root.left, currentTime, landedFlights);

        if (root.key <= currentTime) {
            landedFlights.add(root.key);
        }

        collectLandedFlights(root.right, currentTime, landedFlights);
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
