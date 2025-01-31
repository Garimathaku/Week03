package com.day2.stackandqueue;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Output array
        Deque<Integer> deque = new LinkedList<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Remove elements from the front if they are out of the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index at the back
            deque.offerLast(i);

            // Store the maximum of the window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Taking input for array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Taking input for window size
        System.out.print("Enter the window size (k): ");
        int k = scanner.nextInt();

        // Validate k
        if (k > n || k <= 0) {
            System.out.println("Invalid window size. It should be between 1 and " + n);
            return;
        }

        // Compute the sliding window maximum
        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.println("Sliding Window Maximums: " + Arrays.toString(result));

        scanner.close();
    }
}
