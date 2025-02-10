package com.week3.day4.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CountOccurrenceUsingFileReader {

    // Method to count occurrences of a word in a file
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                // Check each word and count occurrences
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/day4/test.txt";
        String targetWord = "welcome";

        // Call method to count occurrences
        int count = countWordOccurrences(filePath, targetWord);

        // Print the result
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}
