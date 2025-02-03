package com.day3;

import java.util.Scanner;

public class MergeSort {
    // Function to merge two sorted halves
    static void merge(int prices[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to perform Merge Sort
    static void mergeSort(int prices[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
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

        // Taking input for number of books
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();

        int prices[] = new int[n];

        // Taking input for book prices
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Original Book Prices:");
        printArray(prices);

        // Sorting the book prices
        mergeSort(prices, 0, n - 1);

        System.out.println("Sorted Book Prices:");
        printArray(prices);

        scanner.close();
    }
}
