package com.nadia.crackcode.ch2_linked_lists;

import com.nadia.crackcode.utils.lists.LinkedList;
import com.nadia.crackcode.utils.lists.LinkedNode;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
 * earlier node, so as to make a loop in the linked list
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */
public class Task2_5 {

    public static void main(String args[]) {
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(2);
        list1.append(3);
        LinkedNode loopNode = list1.append(4);
        list1.append(5);
        list1.append(6);
        list1.append(7);
        LinkedNode lastNode = list1.append(8);
        lastNode.setNext(loopNode);
        list1.printLoop();
        System.out.println("LOOP: " + findLoop(list1));
    }

    public static LinkedNode findLoop(LinkedList list) {
        LinkedNode start1 = list.getStart();
        LinkedNode start2 = list.getStart();
        boolean isBegin = true;
        while (start1 != start2 || isBegin) {
            start1 = start1.getNext();
            start2 = start2.getNext().getNext();
            isBegin = false;
        }
        start1 = list.getStart();
        while (start1 != start2) {
            start1 = start1.getNext();
            start2 = start2.getNext();
        }
        return start1;
    }

}
