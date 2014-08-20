package com.nadia.crackcode.utils.lists;

/**
 * BLinkedList node object
 */
public class BLinkedNode {
    private int value;
    private BLinkedNode next;
    private BLinkedNode previous;

    public BLinkedNode() {
        this(0);
    }

    public BLinkedNode(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BLinkedNode getNext() {
        return next;
    }

    public void setNext(BLinkedNode next) {
        this.next = next;
    }

    public BLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(BLinkedNode previous) {
        this.previous = previous;
    }

    public void detach() {
        this.previous.setNext(this.next);
        if (this.next != null) {
            this.next.setPrevious(this.previous);
        }
    }

    public void attachBefore (BLinkedNode next) {
        BLinkedNode prev = next.getPrevious();
        this.setNext(next);
        this.setPrevious(prev);
        next.setPrevious(this);
        prev.setNext(this);
    }

    @Override
    public String toString() {
        return "BLinkedNode{" +
                "value=" + value +
                '}';
    }
}
