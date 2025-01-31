package com.day2.hashmaps;

import java.util.*;

public class PairWithGivenSum {
    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>(); // HashSet to store visited numbers

        for (int num : arr) {
            int required = target - num;
            if (seen.contains(required)) {
                return true;
            }
            seen.add(num);
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Taking input for array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking input for the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Check if a pair exists
        if (hasPairWithSum(arr, target)) {
            System.out.println("Yes, there exists a pair with sum " + target);
        } else {
            System.out.println("No, no such pair exists.");
        }

        scanner.close();
    }
}
