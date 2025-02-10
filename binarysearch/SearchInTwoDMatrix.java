package com.week3.day4.binarysearch;

import java.util.Scanner;

public class SearchInTwoDMatrix {

    // Function to search for the target value in a 2D sorted matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Initialize left and right pointers for binary search
        int left = 0;
        int right = rows * columns - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert mid to row and column indices
            int row = mid / columns;
            int col = mid % columns;

            // Check if the target is found
            if (matrix[row][col] == target) {
                return true;
            }
            // If the target is smaller, search the left half
            else if (matrix[row][col] > target) {
                right = mid - 1;
            }
            // If the target is larger, search the right half
            else {
                left = mid + 1;
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking the size of the matrix
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Taking the elements of the matrix
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Taking the target value
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Search and display the result
        boolean found = searchMatrix(matrix, target);
        if (found) {
            System.out.println("Target found in the matrix.");
        } else {
            System.out.println("Target not found in the matrix.");
        }

        sc.close();
    }
}
