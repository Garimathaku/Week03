package com.day3;

import java.util.Scanner;

public class BubbleSort {
    // Function to perform Bubble Sort
    static void bubbleSort(int marks[]) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap adjacent elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in this iteration, break
            if (!swapped)
                break;
        }
    }

    // Function to print the array
    static void printArray(int marks[]) {
        for (int mark : marks)
            System.out.print(mark + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int marks[] = new int[n];

        // Taking input for marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        System.out.println("Original Marks:");
        printArray(marks);

        // Sorting the marks
        bubbleSort(marks);

        System.out.println("Sorted Marks:");
        printArray(marks);

        scanner.close();
    }
}
