package com.week3.day4.binarysearch;

import java.util.Scanner;

public class FirstAndLastOccurrence {

    // Function to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Continue searching on the left side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Function to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Continue searching on the right side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the sorted array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Taking the target value
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Find the first and last occurrence
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        if (first != -1 && last != -1) {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        } else {
            System.out.println("Element not found.");
        }

        sc.close();
    }
}
