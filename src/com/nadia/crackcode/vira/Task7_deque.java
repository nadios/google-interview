package com.nadia.crackcode.vira;

import java.util.LinkedList;
import java.util.List;

/**
 * to implement a special double ended queue (deque)
 */
public class Task7_deque {

    private interface IQueue {
        public void enqueue(Object value);

        public Object dequeue() throws EmptyQueueException;

        public void clear();

        public int size();

        public boolean isEmpty();
    }

    private class Queue implements IQueue {

        private final List _list;

        private Queue(List list) {
            _list = list;
        }

        public Queue() {
            this(new LinkedList());
        }

        @Override
        public void enqueue(Object value) {
            _list.add(value);
        }

        @Override
        public Object dequeue() throws EmptyQueueException {
//            return _list.remove(0);
            return ((LinkedList)_list).removeLast();
        }

        @Override
        public void clear() {
            _list.clear();
        }

        @Override
        public int size() {
            return _list.size();
        }

        @Override
        public boolean isEmpty() {
            return _list.isEmpty();
        }
    }

    private class EmptyQueueException extends RuntimeException {
    }
}
