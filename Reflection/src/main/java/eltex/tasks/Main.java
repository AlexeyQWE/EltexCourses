package main.java.eltex.tasks;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void ShowPhones (Object myClass) {

        try {
            Method met = myClass.getClass().getDeclaredMethod("ShowNumber");
            met.setAccessible(true);
            met.invoke(myClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Student ref = new Student();
        String name =  null;
        String number =  null;

        try {
            Field fl = ref.getClass().getDeclaredField("name");
            fl.setAccessible(true);
            name = (String) fl.get(ref);
            System.out.println("Student 1 - " + name);
            fl.set(ref, (String) "Alexey");
            name = (String) fl.get(ref);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ShowPhones(ref);
        System.out.println("Student 2 - " + name);

        try {
            Field fl = ref.getClass().getDeclaredField("number");
            fl.setAccessible(true);
            fl.set(ref, (String) "+71231231212");
            number = (String) fl.get(ref);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ShowPhones(ref);


    }
}
