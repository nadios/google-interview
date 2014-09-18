package com.nadia.crackcode.ch2_linked_lists;

import com.nadia.crackcode.utils.lists.LinkedList;
import com.nadia.crackcode.utils.lists.LinkedNode;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */
public class Task2_4 {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(2);
        list1.append(8);
        System.out.println("INIT 1  : " + list1.toString());
        LinkedList list2 = new LinkedList();
        list2.append(1);
        list2.append(9);
        list2.append(3);
        System.out.println("INIT 2  : " + list2.toString());
        System.out.println("RESULT  : " + addNumbers(list1, list2).toString());
    }

    //cycle
    public static LinkedList addNumbers(LinkedList list1, LinkedList list2) {
        LinkedNode node1 = list1.getStart();
        LinkedNode node2 = list2.getStart();
        LinkedList result = new LinkedList();
        Integer div = 0;
        while (node1 != null || node2 != null || div > 0) {
            Integer value1 = 0;
            Integer value2 = 0;
            if (node1 != null) {
                value1 = node1.getValue();
                node1 = node1.getNext();
            }
            if (node2 != null) {
                value2 = node2.getValue();
                node2 = node2.getNext();
            }
            Integer value = value1 + value2 + div;
            if (value >= 10) {
                div = (Integer) value / 10;
                value = value % 10;
            } else {
                div = 0;
            }
            result.append(value);
        }
        return result;
    }

    //TODO: recursion
    public static LinkedList addNums(LinkedList list1, LinkedList list2) {
        return null;
    }

}
