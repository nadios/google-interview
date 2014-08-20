package com.nadia.crackcode.utils.lists;

public class LinkedNode {
    private int value;
    private LinkedNode next;

    public LinkedNode() {
        this(0);
    }

    public LinkedNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value=" + value +
                '}';
    }
}
