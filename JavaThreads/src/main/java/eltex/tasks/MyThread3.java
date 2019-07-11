package eltex.tasks;

public class MyThread3 implements Runnable  {

    private int thread_id;

    MyThread3 (int thread_id) {

        this.thread_id = thread_id;
    }

    public void run () {
        System.out.println("Thread " + thread_id);
        Volatile.increaseA();
    }
}
