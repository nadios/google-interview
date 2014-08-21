package com.nadia.crackcode.utils.lists;

import java.util.Arrays;

/**
 * Task3.1 Describe how you could use a single array to implement three stacks
 */
public class StackArray {

    int size = 100;
    int indexUsed = 0;
    int[] pointer = {-1, -1, -1};
    StackArrayNode[] buffer = new StackArrayNode[size * 3];

    public void push(int value, int stackNum) {
        int lastInd = pointer[stackNum];
        pointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[pointer[stackNum]] = new StackArrayNode(value, lastInd);
    }

    public int pop(int stackNum) {
        int value = buffer[pointer[stackNum]].getValue();
        int lastInd = pointer[stackNum];
        pointer[lastInd] = buffer[pointer[stackNum]].getPrevious();
        buffer[lastInd] = null;
        indexUsed--;
        return value;
    }

    int peek(int stack) {
        return buffer[pointer[stack]].value;
    }

    boolean isEmpty(int stackNum) {
        return pointer[stackNum] == -1;
    }

    @Override
    public String toString() {
        return "StackArray{" +
                "buffer=" + (buffer == null ? null : Arrays.asList(buffer)) +
                '}';
    }
}

