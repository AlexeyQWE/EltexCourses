package eltex.tasks;

public class MyThread2 implements Runnable {

    private int thread_id;

    MyThread2 (int thread_id) {

        this.thread_id = thread_id;
    }

    public void run () {
        System.out.println("Thread " + thread_id);
        MySynchronized.increaseA();
    }
}
