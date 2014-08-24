package com.nadia.crackcode.ch4_graphs_and_trees;

import com.nadia.crackcode.utils.search.BiTreeNode;

import java.util.ArrayList;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum up to that value. Note that it can be any path in the tree
 * - it does not have to start at the root.
 */
public class Task4_8 {

    public static void main(String[] args) {
        //           ___________I(11)__________
        //          /                          \
        //         D(6)                       M(19)
        //     /         \                /         \
        //   B(3)         F(8)          K(14)       Q(22)
        //  /    \      /     \        /     \      /    \
        //A(1)   C(5)  E(7)   H(10)  J(12)  L(18) N(20)  R(25)
        BiTreeNode vertexA = new BiTreeNode(1, "A", null, null);
        BiTreeNode vertexC = new BiTreeNode(5, "C", null, null);
        BiTreeNode vertexB = new BiTreeNode(3, "B", vertexA, vertexC);
        BiTreeNode vertexE = new BiTreeNode(7, "E", null, null);
        BiTreeNode vertexH = new BiTreeNode(10, "H", null, null);
        BiTreeNode vertexF = new BiTreeNode(8, "F", vertexE, vertexH);
        BiTreeNode vertexJ = new BiTreeNode(12, "J", null, null);
        BiTreeNode vertexL = new BiTreeNode(18, "L", null, null);
        BiTreeNode vertexK = new BiTreeNode(14, "K", vertexJ, vertexL);
        BiTreeNode vertexN = new BiTreeNode(20, "N", null, null);
        BiTreeNode vertexR = new BiTreeNode(25, "R", null, null);
        BiTreeNode vertexQ = new BiTreeNode(22, "Q", vertexN, vertexR);
        BiTreeNode vertexD = new BiTreeNode(6, "D", vertexB, vertexF);
        BiTreeNode vertexM = new BiTreeNode(19, "M", vertexK, vertexQ);
        BiTreeNode vertexI = new BiTreeNode(11, "I", vertexD, vertexM);
        BiTreeNode.print_line(vertexI);

        findSum(9, vertexI, new ArrayList<Integer>(), 0);
        findSum(14, vertexI, new ArrayList<Integer>(), 0);
        findSum(25, vertexQ, new ArrayList<Integer>(), 0);
    }

    private static void printPath(ArrayList<Integer> result, int start, int end) {
        for (int x = start; x < end; x++) {
            System.out.print(result.get(x) + "+");
        }
        System.out.print(result.get(end));
        System.out.println(".");
    }

    public static void findSum(int sum, BiTreeNode vrtx, ArrayList<Integer> buffer, int lvl) {
        if (vrtx == null) return;
        int temp = sum;
        buffer.add(vrtx.getValue());
        for (int i = lvl; i > -1; i--) {
            temp -= buffer.get(i);
            if (temp == 0) {
                System.out.print(sum + "=");
                printPath(buffer, i, lvl);
            }
        }
        ArrayList<Integer> bufferL = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> bufferR = (ArrayList<Integer>) buffer.clone();
        findSum(sum, vrtx.getLeft(), bufferL, lvl + 1);
        findSum(sum, vrtx.getRight(), bufferR, lvl + 1);
    }
}
