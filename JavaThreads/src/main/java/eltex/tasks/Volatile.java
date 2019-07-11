package eltex.tasks;

public class Volatile {

    private static volatile int a = 0;

    public static void increaseA() {
        a = a + 1;
        System.out.println("a = " +  a);
    }
}
