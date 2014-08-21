package com.nadia.crackcode.utils.search;

/**
 * TreeNode Implementation
 */
public class TreeNode {

    String name;
    TreeNode left;
    TreeNode right;

    public TreeNode(String name, TreeNode left, TreeNode right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "'" + name + "\'  ";
    }

    //         I
    //      /     \
    //     D       M
    //    / \     / \
    //   A   F   K   Q
    //    \
    //     N
    public static TreeNode generateTree() {
        TreeNode vertexN = new TreeNode("N", null, null);
        TreeNode vertexA = new TreeNode("A", null, vertexN);
        TreeNode vertexF = new TreeNode("F", null, null);
        TreeNode vertexD = new TreeNode("D", vertexA, vertexF);
        TreeNode vertexK = new TreeNode("K", null, null);
        TreeNode vertexQ = new TreeNode("Q", null, null);
        TreeNode vertexM = new TreeNode("M", vertexK, vertexQ);
        TreeNode vertexI = new TreeNode("I", vertexD, vertexM);
        return vertexI;
    }
}
