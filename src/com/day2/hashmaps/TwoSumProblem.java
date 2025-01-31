package com.day2.hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSumProblem {
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return the indices
            }

            map.put(nums[i], i); // Store the index of the current element
        }

        return new int[]{-1, -1}; // Return -1 if no pair is found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Find two sum indices
        int[] result = findTwoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices of elements that sum to target: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No pair found that sums to the target.");
        }

        scanner.close();
    }
}
