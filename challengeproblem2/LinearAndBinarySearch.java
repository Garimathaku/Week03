package com.week3.day4.challengeproblem2;

import java.util.Arrays;
import java.util.Scanner;

public class LinearAndBinarySearch {

    // Linear Search to find the first missing positive integer
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Mark the elements that are out of range or negative as n + 1 (a number outside the valid range)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Use the array itself to mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        // The first index that is not marked negative corresponds to the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // If no missing positive, return n + 1
        return n + 1;
    }

    // Binary Search to find the index of the target number
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at the middle
            if (arr[mid] == target) {
                return mid;
            }
            // If the target is smaller, search the left half
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is larger, search the right half
            else {
                left = mid + 1;
            }
        }

        // If target is not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the list of integers
        System.out.print("Enter the number of elements in the list: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find the first missing positive integer using Linear Search
        int firstMissing = findFirstMissingPositive(arr);
        System.out.println("The first missing positive integer is: " + firstMissing);

        // Taking input for the target value to search
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Sort the array for Binary Search
        Arrays.sort(arr);

        // Find the index of the target using Binary Search
        int targetIndex = binarySearch(arr, target);
        if (targetIndex != -1) {
            System.out.println("Target found at index: " + targetIndex);
        } else {
            System.out.println("Target not found in the list.");
        }

        sc.close();
    }
}
