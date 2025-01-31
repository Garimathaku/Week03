package com.day2.hashmaps;

import java.util.*;

public class SubarraysWithZeroSum {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int cumulativeSum = 0;

        // Initialize with sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If cumulative sum is found in map, get all indices where it occurred
            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIdx : sumMap.get(cumulativeSum)) {
                    result.add(Arrays.asList(startIdx + 1, i)); // Store the subarray indexes
                }
            }

            // Add current index to the map for future matches
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
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

        // Finding all zero-sum subarrays
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        // Printing the result
        if (subarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Zero sum subarrays found at indices: ");
            for (List<Integer> subarray : subarrays) {
                System.out.println(subarray);
            }
        }

        scanner.close();
    }
}
