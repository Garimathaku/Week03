package com.week3.day4.stringbuffer;

import java.util.Scanner;

public class ConcatenateString {

    // Method to concatenate an array of strings
    public static String concatenateStrings(String[] strArray) {
        StringBuilder result = new StringBuilder();
        for (String word : strArray) {
            result.append(word);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define the string array
        String[] str = {"hii", "welcome"};

        // Call method to concatenate strings
        String concatenatedString = concatenateStrings(str);

        // Print the results
        System.out.println("Array of Strings: " + String.join(", ", str));
        System.out.println("Concatenated String: " + concatenatedString);

        sc.close();
    }
}