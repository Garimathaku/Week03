package com.week3.day4.stringbuilder;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    // Method to remove duplicate characters from a string
    public static String removeDuplicateCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input from user
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Call method to remove duplicate characters
        String newString = removeDuplicateCharacters(str);

        // Print the results
        System.out.println("Original String: " + str);
        System.out.println("New String: " + newString);

        sc.close();
    }
}
