package com.nadia.crackcode.ch2_linked_lists;

import com.nadia.crackcode.utils.lists.LinkedList;
import com.nadia.crackcode.utils.lists.LinkedNode;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 */
public class Task2_2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(6);
        list.append(3);
        list.append(6);
        list.append(8);
        list.append(2);
        list.append(8);
        list.append(0);
        list.append(8);
        System.out.println("INIT: " + list.toString());
        System.out.println("find 2nd : " + find_nth(list, 2));
        System.out.println("find 1st : " + find_nth(list, 1));
        System.out.println("find 0 : " + find_nth(list, 0));
        System.out.println("find 4 : " + find_nth(list, 4));
        System.out.println("find 10 : " + find_nth(list, 10));

    }

    public static Integer find_nth(LinkedList list, int n) {
        LinkedNode current = list.getStart();
        LinkedNode result = list.getStart();
        int index = 0;
        while (index <= n) {
            current = current.getNext();
            index++;
            if (current == null) {
                return null;
            }
        }
        while (current != null) {
            result = result.getNext();
            current = current.getNext();
        }
        return result.getValue();
    }
}
