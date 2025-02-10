package com.week3.day4.binarysearch;

import java.util.Scanner;
public class FindRotationPointInArray {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            if (arr[mid] > arr[right]) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid; // Search in the left half
            }
        }
        return left; // Index of the smallest element (rotation point)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the array size
        System.out.print("Enter the number of elements in the rotated sorted array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Taking input for the array elements
        System.out.println("Enter the rotated sorted array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Finding the rotation point
        int rotationIndex = findRotationPoint(arr);

        // Printing the result
        System.out.println("Rotation point (smallest element) found at index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);

        sc.close();
    }
}
