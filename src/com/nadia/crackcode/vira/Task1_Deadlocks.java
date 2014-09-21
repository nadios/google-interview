package com.nadia.crackcode.vira;

/**
 * написать пример deadlock-ов и потом его исправить
 */
public class Task1_Deadlocks {

    final static Object LOCK_A = new Object();
    final static Object LOCK_B = new Object();

    public static void main (String[] args) {
        System.out.println("Start");
        Thread thread1 = new Thread(new Thread1());
        thread1.start();
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
        System.out.println("Finish");

    }

    private static class Thread1 implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK_A) {
                try {
                    System.out.println("Thread #1 inside LOCK A");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread #1 waiting for LOCK B");
                synchronized (LOCK_B) {
                    System.out.println("Thread #1 inside LOCK A & B");
                }
            }

        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK_B) {  // 1) synchronized (LOCK_A) { <----- to fix deadlock
                System.out.println("Thread #2 inside LOCK B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread #2 waiting for LOCK A");
                synchronized (LOCK_A) {  // 2) synchronized (LOCK_B) { <----- to fix deadlock
                    System.out.println("Thread #2 inside LOCK B & A");
                }
            }

        }
    }

}
