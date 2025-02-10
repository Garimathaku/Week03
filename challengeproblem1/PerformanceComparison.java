package com.week3.day4.challengeproblem1;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaders("src/main/java/day4/test.txt");
    }

    // Method to compare StringBuilder and StringBuffer
    public static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        // StringBuilder Test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);

        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000 + " ms");

        // StringBuffer Test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
         }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000 + " ms");

        // Comparison
        System.out.println("StringBuilder is " + (stringBufferTime / (double) stringBuilderTime) + " times faster than StringBuffer.");
    }

    // Method to compare FileReader and InputStreamReader
    public static void compareFileReaders(String filePath) {
        System.out.println("\nComparing FileReader vs. InputStreamReader for word counting:");

        // FileReader Test
        long startTime = System.nanoTime();
        int fileReaderWords = countWordsWithFileReader(filePath);
        long endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;
        System.out.println("FileReader word count: " + fileReaderWords);
        System.out.println("Time taken by FileReader: " + fileReaderTime / 1_000_000 + " ms");

        // InputStreamReader Test
        startTime = System.nanoTime();
        int inputStreamReaderWords = countWordsWithInputStreamReader(filePath);
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;
        System.out.println("InputStreamReader word count: " + inputStreamReaderWords);
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime / 1_000_000 + " ms");

        // Comparison
        System.out.println("FileReader is " + (inputStreamReaderTime / (double) fileReaderTime) + " times faster/slower than InputStreamReader.");
    }

    // Method to count words using FileReader
    public static int countWordsWithFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Method to count words using InputStreamReader
    public static int countWordsWithInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
