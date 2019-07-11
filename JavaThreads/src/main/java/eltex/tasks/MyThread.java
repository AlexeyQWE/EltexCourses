package eltex.tasks;

public class MyThread implements Runnable{

    private int thread_id;

    MyThread (int thread_id) {

        this.thread_id = thread_id;
    }

    public void run () {
        System.out.println("Thread " + thread_id);
        MyRentrantlock.increaseA();
    }
}

