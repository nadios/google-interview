package com.nadia.crackcode.utils.search;

import java.util.ArrayList;

/**
 * TreeNode Implementation
 */
public class BiTreeNode {

    String name;
    BiTreeNode left;
    BiTreeNode right;
    BiTreeNode parent;
    Integer value;

    public BiTreeNode(String name, BiTreeNode left, BiTreeNode right) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.parent = null;
        this.value = 0;
        if (this.left != null) {
            this.left.setParent(this);
        }
        if (this.right != null) {
            this.right.setParent(this);
        }
    }

    public BiTreeNode(Integer value, String name, BiTreeNode left, BiTreeNode right) {
        this(name,left,right);
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BiTreeNode getLeft() {
        return left;
    }

    public void setLeft(BiTreeNode left) {
        this.left = left;
        this.left.setParent(this);
    }

    public BiTreeNode getRight() {
        return right;
    }

    public void setRight(BiTreeNode right) {
        this.right = right;
        this.right.setParent(this);
    }

    public BiTreeNode getParent() {
        return parent;
    }

    public void setParent(BiTreeNode parent) {
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + name + "(" + this.value + ")  ";// (parent= " + this.getParent() + ")  ";
    }

    //        _____I_____
    //       /           \
    //      D             M
    //    /   \         /   \
    //   B     F       K     Q
    //  / \   / \     / \   /  \
    // A   C E   H   J   L N    R
    public static BiTreeNode generateTreeI() {
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
        return vertexI;
    }

    public static void print_line(BiTreeNode vertex) {
        ArrayList curLine = new ArrayList();
        curLine.add(vertex);

        while (curLine.size() > 0) {
            ArrayList nextLine = new ArrayList();
            for (int i = 0; i < curLine.size(); i++) {
                BiTreeNode node = (BiTreeNode) curLine.get(i);
                System.out.print(node);
                if (node.getLeft() != null) {
                    nextLine.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLine.add(node.getRight());
                }
            }
            System.out.println("");
            curLine = nextLine;
        }
    }
}
