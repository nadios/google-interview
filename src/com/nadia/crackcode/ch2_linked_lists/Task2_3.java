package com.nadia.crackcode.ch2_linked_lists;

import com.nadia.crackcode.utils.lists.LinkedList;
import com.nadia.crackcode.utils.lists.LinkedNode;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class Task2_3 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedNode node1 = list.append(1);
        LinkedNode node2 = list.append(2);
        LinkedNode node3 = list.append(3);
        LinkedNode node4 = list.append(4);
        LinkedNode node5 = list.append(5);
        LinkedNode node6 = list.append(6);
        LinkedNode node7 = list.append(7);
        LinkedNode node8 = list.append(8);
        LinkedNode node9 = list.append(9);
        System.out.println("INIT         : " + list.toString());
        removeNode(node3, list);
        System.out.println("REMOVED node3: " + list.toString());
        removeNode(node1, list);
        System.out.println("REMOVED node1: " + list.toString());
        removeNode(node9, list);
        System.out.println("REMOVED node9: " + list.toString());

    }

    public static void removeNode(LinkedNode node, LinkedList list) {
        LinkedNode current = list.getStart();
        if (current == node) {
            list.setStart(current.getNext());
        } else {
            while (current.getNext() != node) {
                current = current.getNext();
            }
            current.setNext(node.getNext());
        }
    }
}
