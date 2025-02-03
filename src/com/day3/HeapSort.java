package com.day3;

import java.util.Scanner;

public class HeapSort {
    // Function to build a max heap
    static void heapify(int salaries[], int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest])
            largest = right;

        // If largest is not root, swap and heapify the affected subtree
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Function to perform Heap Sort
    static void heapSort(int salaries[]) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to the end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to print the array
    static void printArray(int salaries[]) {
        for (int salary : salaries)
            System.out.print(salary + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of job applicants
        System.out.print("Enter the number of job applicants: ");
        int n = scanner.nextInt();

        int salaries[] = new int[n];

        // Taking input for salary demands
        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }

        System.out.println("Original Salary Demands:");
        printArray(salaries);

        // Sorting the salary demands using Heap Sort
        heapSort(salaries);

        System.out.println("Sorted Salary Demands:");
        printArray(salaries);

        scanner.close();
    }
}
