package com.nadia.crackcode.utils.lists;

/**
 * Represents a node for array of 3 stacks
 */
public class StackArrayNode {

    int value;
    int previous;

    public StackArrayNode(int value, int previous) {
        this.value = value;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public int getPrevious() {
        return previous;
    }
}
