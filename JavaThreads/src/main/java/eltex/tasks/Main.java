package eltex.tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static double dt= 1e-9;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Locks with Rentrantlock");
        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread(i);
            Thread t = new Thread (r);
            t.start();
        }
        Thread.sleep(2000);
        System.out.println("\n\nLocks with Semaphore");

        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread1(i);
            Thread t = new Thread (r);
            t.start();
        }
        Thread.sleep(2000);

        System.out.println("\n\nLocks with Synchronized");

        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread2(i);
            Thread t = new Thread (r);
            t.start();
        }
        Thread.sleep(2000);

        System.out.println("\n\nLocks with Volatile");

        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread3(i);
            Thread t = new Thread (r);
            t.start();
        }
        Thread.sleep(2000);

        MyRentrantlock.zerro();

        System.out.println("\n\nThread pool");

        ExecutorService exec = Executors.newFixedThreadPool(10);
        Runnable r = new MyThread(10);

        long startTime = System.nanoTime();

        for (int i = 0; i < 10000; ++i) {
            exec.submit(r);
        }
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        long stopTime = System.nanoTime();
        System.out.println("Elapsed time: " + (stopTime - startTime) * dt);

    }
}
