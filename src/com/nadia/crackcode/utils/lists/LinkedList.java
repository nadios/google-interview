package com.nadia.crackcode.utils.lists;

/**
 * My Implementation of LinkedList
 */
public class LinkedList {
    private LinkedNode start;

    public LinkedNode getStart() {
        return start;
    }

    public LinkedList() {

        this.start = null;
    }

    public void append(int value) {
        if (this.start == null) {
            this.start = new LinkedNode(value);
        } else {
            LinkedNode node = this.start;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new LinkedNode(value));
        }
    }

//    public Integer pop() {
//        LinkedNode node = this.start;
//        while (node.getNext() != null) {
//            node = node.getNext();
//        }
//        Integer val = node.getValue();
//
//        return node.getValue();
//    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedNode node = this.start;
        while (node.getNext() != null) {
            sb.append(node.getValue());
            sb.append(", ");
            node = node.getNext();
        }
        sb.append(node.getValue());
        return sb.toString();
    }
}
