package eltex.tasks;

public class MyThread1 implements Runnable {

    private int thread_id;

    MyThread1 (int thread_id) {

        this.thread_id = thread_id;
    }

    public void run () {
        System.out.println("Thread " + thread_id);
        try {
            MySemaphore.increaseA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
