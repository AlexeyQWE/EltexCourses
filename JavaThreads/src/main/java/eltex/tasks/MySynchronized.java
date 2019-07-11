package eltex.tasks;

public class MySynchronized {

    private static int a = 0;

    public static synchronized void increaseA() {
        a = a + 1;
        System.out.println("a = " +  a);
    }
}
