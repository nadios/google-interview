package com.nadia.crackcode.utils.lists;

/**
 * My Implementation of Bi Directional LinkedList
 */
public class BLinkedList {

    private BLinkedNode start;
    private BLinkedNode finish;

    public BLinkedList() {
        this.start = null;
        this.finish = null;
    }

    public void append(int value) {
        if (finish == null && start == null) {
            this.finish = this.start = new BLinkedNode(value);
        } else {
            BLinkedNode node = new BLinkedNode(value);
            BLinkedNode prev = this.finish;
            prev.setNext(node);
            node.setPrevious(prev);
            this.finish = node;
        }
    }

    public Integer pop() {
        if (finish == null && start == null) {
            return null;
        } else {
            Integer value = this.finish.getValue();
            BLinkedNode prev = this.finish.getPrevious();
            this.finish.detach();
            this.finish = prev;
            return value;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        BLinkedNode node = this.start;
        while (node.getNext() != null) {
            sb.append(node.getValue());
            sb.append(", ");
            node = node.getNext();
        }
        sb.append(node.getValue());
        return sb.toString();
    }



}
