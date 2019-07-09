package eltex.tasks;

import java.io.IOException;
import java.util.*;


public class Main {

    private static double dt= 1e-9;

    public static void main(String[] args) throws IOException {

        HashSet <Integer> hset = new HashSet<Integer>();
        Map<Integer, Integer> hmap = new HashMap <Integer, Integer>();
        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000000) + 1;
        }

        HashSet_HashMap_Test(hset, hmap, arr);

        LinkedList <Integer> list = new LinkedList <Integer> ();
        ArrayList <Integer> arrlist = new ArrayList<>();
        TreeSet <Integer> tree = new TreeSet<Integer>();

        LinkedList_ArrayList_TreeSet_Test(list ,arrlist, tree, arr);

    }

    public static void HashSet_HashMap_Test (  HashSet <Integer> hset,  Map<Integer, Integer> hmap, int [] arr) {

        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; ++i) {
            hset.add(arr[i]);
        }
        long stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Add HashSet): "+ (stopTime - startTime) * dt + ".sec");

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length / 2; ++i) {
            hset.remove(arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Remove HashSet): "+ (stopTime - startTime) * dt + ".sec\n");

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; ++i) {
            hmap.put(arr[i], arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Add HashMap): "+ (stopTime - startTime) * dt + ".sec");

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length / 2; ++i) {
            hset.remove(arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Remove HashMap): "+ (stopTime - startTime) * dt + ".sec");
    }

    public static void LinkedList_ArrayList_TreeSet_Test(LinkedList <Integer>  list,  ArrayList <Integer> arrlist,  TreeSet <Integer> tree,  int [] arr) {

        for (int i = 0; i < arr.length; ++i) {
            list.add(arr[i]);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length / 100000; ++i) {
            list.add(600000, arr[i]);
        }
        long stopTime = System.nanoTime();
        System.out.println("\nElapsedTime (Add Linkedlist): "+ (stopTime - startTime) * dt + ".sec");

       startTime = System.nanoTime();
        for (int i = 100000; i < arr.length / 2; ++i) {
            list.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Remove Linkedlist): " + (stopTime - startTime) * dt + ".sec\n");

        for (int i = 0; i < arr.length; ++i) {
            arrlist.add(arr[i]);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length / 100000; ++i) {
            arrlist.add(600000, arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Add Arraylist): " + (stopTime - startTime) * dt + ".sec");

        startTime = System.nanoTime();
        for (int i = 100000; i < arr.length / 2; ++i) {
            arrlist.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Remove Arraylist): " + (stopTime - startTime) * dt + ".sec\n");

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; ++i) {
            tree.add(arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Add TreeSet): " + (stopTime - startTime) * dt + ".sec");

        startTime = System.nanoTime();
        for (int i = 0; i < arr.length / 2; ++i) {
            tree.remove(arr[i]);
        }
        stopTime = System.nanoTime();
        System.out.println("ElapsedTime (Remove TreeSet): " + (stopTime - startTime) * dt + ".sec");
    }


}
