package com.day3;

import java.util.Scanner;

public class SelectionSort {
    // Function to perform Selection Sort
    static void selectionSort(int scores[]) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the first unsorted element is the smallest

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Function to print the array
    static void printArray(int scores[]) {
        for (int score : scores)
            System.out.print(score + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int scores[] = new int[n];

        // Taking input for exam scores
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println("Original Exam Scores:");
        printArray(scores);

        // Sorting the scores using Selection Sort
        selectionSort(scores);

        System.out.println("Sorted Exam Scores:");
        printArray(scores);

        scanner.close();
    }
}
