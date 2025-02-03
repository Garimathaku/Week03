package com.day3;

import java.util.Scanner;

public class CountingSort {
    // Function to perform Counting Sort
    static void countingSort(int ages[], int minAge, int maxAge) {
        int range = maxAge - minAge + 1; // Range of ages (10 to 18)
        int count[] = new int[range]; // Count array
        int output[] = new int[ages.length]; // Output array

        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct order in output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Function to print the array
    static void printArray(int ages[]) {
        for (int age : ages)
            System.out.print(age + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Define age range
        int minAge = 10, maxAge = 18;

        // Taking input for number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int ages[] = new int[n];

        // Taking input for student ages
        System.out.println("Enter the students' ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
            if (ages[i] < minAge || ages[i] > maxAge) {
                System.out.println("Invalid age! Please enter an age between 10 and 18.");
                i--; // Re-enter the value
            }
        }

        System.out.println("Original Student Ages:");
        printArray(ages);

        // Sorting the ages using Counting Sort
        countingSort(ages, minAge, maxAge);

        System.out.println("Sorted Student Ages:");
        printArray(ages);

        scanner.close();
    }
}
