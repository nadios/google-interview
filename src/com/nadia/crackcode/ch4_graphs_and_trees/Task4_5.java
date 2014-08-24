package com.nadia.crackcode.ch4_graphs_and_trees;

import com.nadia.crackcode.utils.search.BiTreeNode;

/**
 * Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in
 * a binary search tree where each node has a link to its parent.
 * ============================================================
 * We approach this problem by thinking very, very carefully about what happens on an in-order traversal
 * On an in-order traversal, we visit X left, then X, then X right
 * So, if we want to find X successor(), we do the following:
 * 1 If X has a right child, then the successor must be on the right side of X (because of the
 * order in which we visit nodes) Specifically, the left-most child must be the first node visited
 * in that subtree
 * 2 Else, we go to X’s parent (call it P)
 * 2 a If X was a left child (P left = X), then P is the successor of X
 * 2 b If X was a right child (P right = X), then we have fully visited P, so we call successor(P)
 */
public class Task4_5 {

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
        System.out.println("Successor of " + vertexI + " is " + findNext(vertexI));
        System.out.println("Successor of " + vertexM + " is " + findNext(vertexM));
        System.out.println("Successor of " + vertexL + " is " + findNext(vertexL));
        System.out.println("Successor of " + vertexE + " is " + findNext(vertexE));
        System.out.println("Successor of " + vertexH + " is " + findNext(vertexH));
    }

    public static BiTreeNode findNext(BiTreeNode current) {
        if (current != null) {
            BiTreeNode parent = current.getParent();
            if (parent == null || current.getRight() != null) {
                parent = findMostLeft(current.getRight());
            } else {
                while ((parent = current.getParent()) != null) {
                    if (current == parent.getLeft()) {
                        break;
                    }
                    current = parent;
                }
            }
            return parent;
        }
        return null;
    }

    public static BiTreeNode findMostLeft(BiTreeNode vertex) {
        if (vertex == null) return null;
        while (vertex.getLeft() != null) vertex = vertex.getLeft();
        return vertex;
    }


}
