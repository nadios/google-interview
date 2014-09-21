package com.nadia.crackcode.victor;

import com.nadia.crackcode.utils.search.TreeNode;

import java.util.LinkedList;

/**
 * print tree by horizontal layers
 */
public class Task3_tree_print_layers {

    public static void main(String[] args) {
        //         I
        //      /     \
        //     D       M
        //    / \     / \
        //   A   F   K   Q
        //    \
        //     N
        TreeNode root = TreeNode.generateTree();
        print_layers(root);
    }

    public static void print_layers(TreeNode root) {
        LinkedList curLine = new LinkedList();
        curLine.add(root);
        while (!curLine.isEmpty()) {
            LinkedList nextLine = new LinkedList();
            for (Object node : curLine) {
                if (node != null) {
                    TreeNode vertex = (TreeNode) node;
                    System.out.print(vertex.getName());
                    nextLine.add(vertex.getLeft());
                    nextLine.add(vertex.getRight());
                }
            }
            System.out.println("");
            curLine = nextLine;
        }
    }
}
