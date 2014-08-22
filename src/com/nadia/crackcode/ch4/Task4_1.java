package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.TreeNode;

/**
 * Implement a function to check if a tree is balanced For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
 * from the root by more than one
 * The idea is very simple: the difference of min depth and max depth should not exceed 1.
 */
public class Task4_1 {

    public static void main(String[] args) {
        System.out.println("Balanced tree : " + isBalanced(TreeNode.generateTree()));
        System.out.println("Balanced tree : " + isBalanced(TreeNode.generateTree1()));
    }

    public static Integer maxDepth(TreeNode vertex) {
        if (vertex == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(vertex.getRight()), maxDepth(vertex.getLeft()));
    }

    public static Integer minDepth(TreeNode vertex) {
        if (vertex == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(vertex.getRight()), minDepth(vertex.getLeft()));
    }

    public static Boolean isBalanced(TreeNode vertex) {
        return maxDepth(vertex) - minDepth(vertex) <= 1;
    }
}
