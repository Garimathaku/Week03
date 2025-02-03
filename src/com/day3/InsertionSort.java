package com.day3;

import java.util.Scanner;

public class InsertionSort {
    // Function to perform Insertion Sort
    static void insertionSort(int employeeIDs[]) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i]; // Pick an element from the unsorted part
            int j = i - 1;

            // Move elements that are greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
            employeeIDs[j + 1] = key; // Insert the key at its correct position
        }
    }

    // Function to print the array
    static void printArray(int employeeIDs[]) {
        for (int id : employeeIDs)
            System.out.print(id + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of employees
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        int employeeIDs[] = new int[n];

        // Taking input for employee IDs
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }

        System.out.println("Original Employee IDs:");
        printArray(employeeIDs);

        // Sorting the Employee IDs
        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs:");
        printArray(employeeIDs);

        scanner.close();
    }
}
