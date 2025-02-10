package com.week3.day5;

import java.util.*;

public class RecursiveVsIterativeFibonacci {
    //create a method to generate fibonacci recursively
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
      //create a method to generate fibonacci iteratively
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
  //main method
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};
        //iterate the loop through each test values
        for (int n : testValues) {
            System.out.println("Fibonacci N: " + n);

            long startTime = System.nanoTime();

            long endTime = System.nanoTime();
            System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) / 1000000.0 + " ms");

            startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            endTime = System.nanoTime();
            System.out.println("Iterative Fibonacci Time: " + (endTime - startTime) / 1000000.0 + " ms");
        }
    }
}