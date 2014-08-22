package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.BreadthFirstSearch;
import com.nadia.crackcode.utils.search.TreeNode;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with
 * minimal height
 */
public class Task4_3 {

    public static void main(String args[]) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 13, 14, 15, 16};
        BreadthFirstSearch.print_line(addToBinaryTree(array, 0, array.length - 1));
    }

    public static TreeNode addToBinaryTree(Integer[] arr, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(Integer.toString(arr[mid]), null, null);
        node.setLeft(addToBinaryTree(arr, start, mid - 1));
        node.setRight(addToBinaryTree(arr, mid + 1, end));
        return node;
    }
}
