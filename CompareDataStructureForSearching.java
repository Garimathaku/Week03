package com.week3.day5;

import java.util.*;


public class CompareDataStructureForSearching {
  //create a method to linear search
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
   //main method
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random random = new Random();
        //iterate through the array of size
        for (int size : sizes) {
            int[] arr = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10);
                arr[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = arr[random.nextInt(size)];

            System.out.println("Dataset Size: " + size);
          //for array
            long startTime = System.nanoTime();
            linearSearch(arr, target);
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1000000.0 + " ms");
            //for HashSet
            startTime = System.nanoTime();
            hashSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");
           //for TreeSet
            startTime = System.nanoTime();
            treeSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

        }
    }
}