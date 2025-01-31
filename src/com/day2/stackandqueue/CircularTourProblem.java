package com.day2.stackandqueue;

import java.util.Scanner;

class CircularTourProblem {
    // Function to find the starting petrol pump index
    public static int findStartingPump(int[] petrol, int[] distance, int n) {
        int total_surplus = 0;
        int current_surplus = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int balance = petrol[i] - distance[i]; // Net gain/loss at pump i
            total_surplus += balance;
            current_surplus += balance;

            // If current_surplus is negative, reset the start index
            if (current_surplus < 0) {
                startIndex = i + 1;
                current_surplus = 0;
            }
        }

        // If total_surplus is negative, no valid starting point exists
        return (total_surplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of petrol pumps
        System.out.print("Enter the number of petrol pumps: ");
        int n = scanner.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        // Taking input for petrol and distance values
        System.out.println("Enter the petrol available at each pump: ");
        for (int i = 0; i < n; i++) {
            petrol[i] = scanner.nextInt();
        }

        System.out.println("Enter the distance to the next pump from each pump: ");
        for (int i = 0; i < n; i++) {
            distance[i] = scanner.nextInt();
        }

        // Finding the starting petrol pump
        int startIndex = findStartingPump(petrol, distance, n);

        // Printing the result
        if (startIndex != -1) {
            System.out.println("Start at petrol pump index: " + startIndex);
        } else {
            System.out.println("No valid starting petrol pump found.");
        }

        scanner.close();
    }
}
