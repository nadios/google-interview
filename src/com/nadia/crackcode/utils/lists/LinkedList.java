package com.nadia.crackcode.utils.lists;

/**
 * My Implementation of LinkedList
 */
public class LinkedList {
    private LinkedNode start;

    public LinkedNode getStart() {
        return start;
    }

    public void setStart(LinkedNode start) {
        this.start = start;
    }

    public LinkedList() {

        this.start = null;
    }

    public LinkedNode append(int value) {
        LinkedNode newNode = new LinkedNode(value);
        if (this.start == null) {
            this.start = newNode;
            return this.start;
        } else {
            LinkedNode node = this.start;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
            return newNode;
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

    public void printLoop() {
        LinkedNode node = this.start;
        int loops = 0;
        while (node.getNext() != null && loops < 15) {
            System.out.print(node.getValue());
            System.out.print(", ");
            node = node.getNext();
            loops++;
        }
        System.out.print(node.getValue());
        System.out.println("...");
    }
}
