package com.day2.hashmaps;

import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num); // Store all elements in HashSet
        }

        int longestStreak = 0;

        for (int num : arr) {
            // Start checking only if num-1 is NOT in the set (to ensure start of sequence)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
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

        // Find and print the length of the longest consecutive sequence
        int result = longestConsecutive(arr);
        System.out.println("Length of the longest consecutive sequence: " + result);

        scanner.close();
    }
}
