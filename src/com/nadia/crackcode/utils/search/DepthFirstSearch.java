package com.nadia.crackcode.utils.search;

import java.util.ArrayList;

/**
 * DFS algo
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        TreeNode vertex = TreeNode.generateTree();
        search(vertex);
        dsearch(vertex);
    }
    //iterative
    public static void search(TreeNode vertex) {
        ArrayList stack = new ArrayList();
        stack.add(vertex);

        while (stack.size() > 0) {
            TreeNode node = (TreeNode) stack.remove(stack.size()-1);
            System.out.println(node);
            if (node.getRight() != null) {
                stack.add(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.add(node.getLeft());
            }
        }
    }

    //recursive
    public static void dsearch(TreeNode vertex) {
        System.out.println(vertex);
        if (vertex.getLeft() != null) dsearch(vertex.getLeft());
        if (vertex.getRight() != null) dsearch(vertex.getRight());
    }

}
