package com.week3.day4.binarysearch;

import java.util.Scanner;

public class PeakElement {

    // Function to find peak element in the array
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return arr[mid];
            }
            // If the element on the left side is greater, search left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // If the element on the right side is greater, search right half
            else {
                left = mid + 1;
            }
        }
        return -1; // This case should not be reached if the array has a peak
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking the size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Taking the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find and display the peak element
        int peak = findPeakElement(arr);
        System.out.println("Peak Element: " + peak);

        sc.close();
    }
}
