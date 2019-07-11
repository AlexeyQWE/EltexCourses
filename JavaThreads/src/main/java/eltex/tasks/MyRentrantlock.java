package eltex.tasks;
import java.util.concurrent.locks.ReentrantLock;

public class MyRentrantlock {

   private static int a = 0;

    public static void increaseA() {

            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            a = a + 1;
            lock.unlock();
            System.out.println("a = " +  a);
    }
    public static void zerro() {

        a = 0;
    }
}
