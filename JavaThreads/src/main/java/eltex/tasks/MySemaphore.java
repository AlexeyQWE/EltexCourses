package eltex.tasks;
import java.util.concurrent.Semaphore;

public class MySemaphore {

    private static int a = 0;
    private  static Semaphore sem = new Semaphore(1);

    public static void increaseA() throws InterruptedException {

        sem.acquire();
        a = a + 1;
        sem.release();
        System.out.println("a = " +  a);
    }

    public static void zerro() {

        a = 0;
    }
}
