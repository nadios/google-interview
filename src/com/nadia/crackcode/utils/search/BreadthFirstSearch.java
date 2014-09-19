package com.nadia.crackcode.utils.search;

import java.util.LinkedList;

/**
 * BFS algo
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        TreeNode vertex = TreeNode.generateTree();
        search(vertex);
        print_line(vertex);
    }

    public static void search(TreeNode vertex) {
        LinkedList queue = new LinkedList();
        queue.add(vertex);

        while (queue.size() > 0) {
            TreeNode node = (TreeNode) queue.remove(0);
            System.out.println(node);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public static void print_line(TreeNode vertex) {
        LinkedList curLine = new LinkedList();
        curLine.add(vertex);

        while (curLine.size() > 0) {
            LinkedList nextLine = new LinkedList();

            for (int i = 0; i < curLine.size(); i++) {
                TreeNode node = (TreeNode) curLine.get(i);
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
