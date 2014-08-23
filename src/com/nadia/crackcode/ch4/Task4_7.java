package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.BiTreeNode;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1
 * ==========================================================
 * Alternative  Approach: The  treeMatch  procedure  visits  each  node  in  the  small  tree  at  most
 * once and is called no more than once per node of the large tree Worst case runtime is at
 * most O(n * m), where n and m are the sizes of trees T1 and T2, respectively If k is the number
 * of occurrences of T2’s root in T1, the worst case runtime can be characterized as O(n + k * m)
 */
public class Task4_7 {

    public static void main(String[] args) {
        BiTreeNode bigTree = BiTreeNode.generateTreeI();

        BiTreeNode vertexN = new BiTreeNode("N", null, null);
        BiTreeNode vertexR = new BiTreeNode("R", null, null);
        BiTreeNode littleTree = new BiTreeNode("Q", vertexN, vertexR);

        BiTreeNode vertexN1 = new BiTreeNode("N", null, null);
        BiTreeNode vertexA = new BiTreeNode("A", null, null);
        BiTreeNode littleTree1 = new BiTreeNode("Q", vertexN1, vertexA);

        System.out.println("Little tree " + littleTree + " is subtree of " + bigTree +
                ": " + containsTree(bigTree, littleTree));
        System.out.println("Little tree " + littleTree1 + " is subtree of " + bigTree +
                ": " + containsTree(bigTree, littleTree1));
    }

    public static Boolean containsTree(BiTreeNode bigTree, BiTreeNode littleTree) {
        if (littleTree == null) return true;
        return subTree(bigTree, littleTree);
    }

    public static Boolean subTree(BiTreeNode bigTree, BiTreeNode littleTree) {
        if (bigTree == null) return false;
        if (bigTree.getName().equals(littleTree.getName())) {
            if (matchTree(bigTree, littleTree)) return true;
        }
        return subTree(bigTree.getLeft(), littleTree) || subTree(bigTree.getRight(), littleTree);
    }

    public static Boolean matchTree(BiTreeNode bigTree, BiTreeNode littleTree) {
        if (bigTree == null && littleTree == null) return true;
        if (bigTree == null || littleTree == null) return false;
        if (!bigTree.getName().equals(littleTree.getName())) return false;
        return matchTree(bigTree.getLeft(), littleTree.getLeft()) &&
                matchTree(bigTree.getRight(), littleTree.getRight());
    }
}
