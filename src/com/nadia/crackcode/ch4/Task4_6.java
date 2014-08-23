package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.BiTreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 * ==============================================
 * For any node r, we know the following:
 * 1   If p is on one side and q is on the other, r is the first common ancestor
 * 2   Else, the first common ancestor is on the left or the right side
 */
public class Task4_6 {

    private static final int NO_FOUND = 0;
    private static final int ONE_FOUND = 1;
    private static final int TWO_FOUND = 2;

    public static void main(String args[]) {
        BiTreeNode vertexA = new BiTreeNode("A", null, null);
        BiTreeNode vertexC = new BiTreeNode("C", null, null);
        BiTreeNode vertexB = new BiTreeNode("B", vertexA, vertexC);
        BiTreeNode vertexE = new BiTreeNode("E", null, null);
        BiTreeNode vertexH = new BiTreeNode("H", null, null);
        BiTreeNode vertexF = new BiTreeNode("F", vertexE, vertexH);
        BiTreeNode vertexJ = new BiTreeNode("J", null, null);
        BiTreeNode vertexL = new BiTreeNode("L", null, null);
        BiTreeNode vertexK = new BiTreeNode("K", vertexJ, vertexL);
        BiTreeNode vertexN = new BiTreeNode("N", null, null);
        BiTreeNode vertexR = new BiTreeNode("R", null, null);
        BiTreeNode vertexQ = new BiTreeNode("Q", vertexN, vertexR);
        BiTreeNode vertexD = new BiTreeNode("D", vertexB, vertexF);
        BiTreeNode vertexM = new BiTreeNode("M", vertexK, vertexQ);
        BiTreeNode vertexI = new BiTreeNode("I", vertexD, vertexM);
        BiTreeNode.print_line(vertexI);
        //        _____I_____
        //       /           \
        //      D             M
        //    /   \         /   \
        //   B     F       K     Q
        //  / \   / \     / \   /  \
        // A   C E   H   J   L N    R
        System.out.println("Ancestor of " + vertexA + " and " + vertexF + " is " +
                findAncestor(vertexI, vertexA, vertexF));
        System.out.println("Ancestor of " + vertexB + " and " + vertexA + " is " +
                findAncestor(vertexI, vertexB, vertexA));
        System.out.println("Ancestor of " + vertexB + " and " + vertexA + " is " +
                findAncestor(vertexD, vertexB, vertexA));
        System.out.println("Ancestor of " + vertexC + " and " + vertexR + " is " +
                findAncestor(vertexI, vertexC, vertexR));
    }

    public static BiTreeNode findAncestor(BiTreeNode root, BiTreeNode node1, BiTreeNode node2) {
        if (node1 == node2 && (node1 == root.getLeft() && node1 == root.getRight())) return root;
        int nodesFromLeft = covers(root.getLeft(), node1, node2);
        if (nodesFromLeft == TWO_FOUND) {
            return findAncestor(root.getLeft(), node1, node2);
        } else if (nodesFromLeft == ONE_FOUND) {
            if (root == node1 || root == node2) return root;
        }
        int nodesFromRight = covers(root.getRight(), node1, node2);
        if (nodesFromRight == TWO_FOUND) {
            return findAncestor(root.getRight(), node1, node2);
        } else if (nodesFromRight == ONE_FOUND) {
            if (root == node1 || root == node2) return root;
        }
        if (nodesFromLeft == ONE_FOUND && nodesFromRight == ONE_FOUND) return root;
        return null;
    }

    private static int covers(BiTreeNode root, BiTreeNode node1, BiTreeNode node2) {
        int result = NO_FOUND;
        if (root == null) return result;
        if (root == node1 || root == node2) result += 1;
        result += covers(root.getLeft(), node1, node2);
        if (result == TWO_FOUND) {
            return result;
        }
        return result + covers(root.getRight(), node1, node2);
    }
}
