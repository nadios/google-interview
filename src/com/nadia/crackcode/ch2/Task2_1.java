package com.nadia.crackcode.ch2;

import com.nadia.crackcode.utils.lists.LinkedList;
import com.nadia.crackcode.utils.lists.LinkedNode;

/**
 * Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Task2_1 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
//        list.append(2);
//        list.append(3);
//        list.append(4);
//        list.append(7);
//        list.append(5);
        list.append(6);

        list.append(3);
        list.append(6);
//        list.append(7);
        list.append(8);
        list.append(2);
        list.append(8);
        list.append(0);
        list.append(8);
        System.out.println("INIT: " + list.toString());
        remove_duplicates(list);
        System.out.println("PROCESSED: " + list.toString());

    }

    public static void remove_duplicates(LinkedList list) {
        LinkedNode current_node = list.getStart();
        while (current_node.getNext() != null) {
            Integer cur_value = current_node.getValue();
            LinkedNode node = current_node.getNext();
            LinkedNode prev = current_node;
            while (node != null) {
                if (cur_value == node.getValue()) {
                    prev.setNext(node.getNext());
                }
                prev = node;
                node = node.getNext();
            }
            current_node = current_node.getNext();
        }
    }

}
