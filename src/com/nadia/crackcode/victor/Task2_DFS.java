package com.nadia.crackcode.victor;

import com.nadia.crackcode.utils.search.TreeNode;

import java.util.LinkedList;

/**
 * implement DFS algo
 */
public class Task2_DFS {

    public static void main(String[] args) {
        //         I
        //      /     \
        //     D       M
        //    / \     / \
        //   A   F   K   Q
        //    \
        //     N
        TreeNode root = TreeNode.generateTree();
        System.out.println("DFS");
        dfs(root);
        System.out.println("BFS");
        bfs(root);
    }

    public static void dfs(TreeNode vertex) {
        if (vertex != null) {
            System.out.println(vertex.getName());
            dfs(vertex.getLeft());
            dfs(vertex.getRight());
        }
    }

    //just in case
    public static void bfs(TreeNode root) {
        LinkedList queue = new LinkedList();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode vrtx = (TreeNode) queue.remove(0);
            if (vrtx != null) {
                System.out.println(vrtx.getName());
                queue.add(vrtx.getLeft());
                queue.add(vrtx.getRight());
            }
        }
    }
}
