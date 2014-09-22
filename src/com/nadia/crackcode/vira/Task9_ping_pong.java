package com.nadia.crackcode.vira;

/**
 * Analyze the memory requirements and write a multi threaded program that prints ping-pong;
 */
public class Task9_ping_pong extends Thread {

    public static void main(String args[]) {
        Object lock = new Object();
        Thread ping = new PingPongThread(lock, "ping");
        Thread pong = new PingPongThread(lock, "pong");
        ping.start();
        pong.start();
    }

    private static class PingPongThread extends Thread {

        private Object lock;
        private String msg;

        private PingPongThread(Object lock, String msg) {
            this.lock = lock;
            this.msg = msg;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println(msg);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
