package eltex.tasks;
import java.lang.reflect.*;

public class Main { 

    //Доступ к приватным методам

     public static void getName (Object myClass) {

        try {
            Method met = myClass.getClass().getDeclaredMethod("getName");
            met.setAccessible(true);
           System.out.print(met.invoke(myClass) + ": ");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

     public static void getNumber (Object myClass) {

        try {
            Method met = myClass.getClass().getDeclaredMethod("getNumber");
            met.setAccessible(true);
           System.out.println(met.invoke(myClass) + "\n");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Student std = new Student("Gena", "+71421421542");
        String name =  null;
        String number =  null;

        // Доступ к приватным полям

        try {
            Field fl = std.getClass().getDeclaredField("name"); 
            fl.setAccessible(true);
            name = (String) fl.get(std);
            System.out.print("Student 1 - ");
            getName(std);
            fl.set(std, (String) "Alexey");
            name = (String) fl.get(std);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        getNumber(std);

        System.out.print("Student 2 - ");
        getName(std);

        try {
            Field fl = std.getClass().getDeclaredField("number");
            fl.setAccessible(true);
            fl.set(std, (String) "+71231231212");
            number = (String) fl.get(std);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        getNumber(std);


        // экземпляр класса с помощью рефлексии :

        Student std2  = null;
        Class obj = null;

        try {                                               // Для конструктора по умолчанию
            obj = Class.forName(Student.class.getName());
            std2 = (Student) obj.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                     e.printStackTrace();
        }

        System.out.println(std2);
        getName(std2);
        getNumber(std2);

        try {                                             //Для конструктора с параметрами
            obj = Class.forName(Student.class.getName());
            Class [] obj2 = {String.class, String.class};
            std2 = (Student) obj.getConstructor (obj2).newInstance("Sergey", "+74351240912");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
                | NoSuchMethodException | InvocationTargetException e) {
                     e.printStackTrace();
        }

        System.out.println(std2);
        getName(std2);
        getNumber(std2);

        Constructor [] cons = obj.getConstructors(); // Информация о параметрах конструктора
        for (Constructor constr : cons) {
             Class[] paramTypes = constr.getParameterTypes();
            for (Class paramType : paramTypes) {
                 System.out.print(paramType.getName() + " ");
             }
        }

    }
}
