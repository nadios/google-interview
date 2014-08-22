package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary search tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists)
 */
public class Task4_4 {
    public static void main(String args[]) {
        TreeNode tree1 = TreeNode.generateTree();
        TreeNode tree2 = TreeNode.generateTree1();

        ArrayList<LinkedList> list1 = new ArrayList<LinkedList>();
        createLinkedListDFS(tree1, list1, 0);
        printList("===Balanced DFS===", list1);

        ArrayList<LinkedList> list2 = new ArrayList<LinkedList>();
        createLinkedListDFS(tree2, list2, 0);
        printList("===Not-Balanced DFS===", list2);

        printList("===Balanced BFS===", createLinkedListBFS(tree1));
        printList("===Not-Balanced BFS===", createLinkedListBFS(tree2));
    }

    //dfs
    public static void createLinkedListDFS(TreeNode vertex, ArrayList<LinkedList> lists, int lvl) {
        if (vertex == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == lvl) { // Level not contained in list
            list = new LinkedList<TreeNode>(); /* Levels are always traversed in order. So,
             * if this is the first time we've visited level i,
			 * we must have seen levels 0 through i - 1.
			 * We can therefore safely add the level at the end. */
            lists.add(list);
        } else {
            list = lists.get(lvl);
        }
        list.add(vertex);
        createLinkedListDFS(vertex.getLeft(), lists, lvl + 1);
        createLinkedListDFS(vertex.getRight(), lists, lvl + 1);
    }

    //bfs
    public static ArrayList<LinkedList> createLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList> result = new ArrayList<LinkedList>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) { /* Visit the children */
                if (parent.getLeft() != null) {
                    current.add(parent.getLeft());
                }
                if (parent.getRight() != null) {
                    current.add(parent.getRight());
                }
            }
        }

        return result;
    }

    private static void printList(String title, ArrayList<LinkedList> alist) {
        System.out.println(title);
        for (LinkedList llist : alist) {
            for (Object node : llist) {
                TreeNode vertex = (TreeNode) node;
                System.out.print(vertex.getName());
            }
            System.out.println("");
        }
    }
}
