package com.day3;

import java.util.Scanner;

public class QuickSort {
    // Function to partition the array
    static int partition(int prices[], int low, int high) {
        int pivot = prices[high]; // Choosing the last element as the pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot into the correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }

    // Function to perform Quick Sort
    static void quickSort(int prices[], int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high); // Get partition index

            // Recursively sort elements before and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Function to print the array
    static void printArray(int prices[]) {
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of products
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        int prices[] = new int[n];

        // Taking input for product prices
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Original Product Prices:");
        printArray(prices);

        // Sorting the product prices using Quick Sort
        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Product Prices:");
        printArray(prices);

        scanner.close();
    }
}
