package com.week3.day5;


public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] iterations = {1000, 10000, 1000000};
        for (int iterationCount : iterations) {
            System.out.println("\nIterations: " + iterationCount);
            displayPerformance(iterationCount);
        }
    }

    public static void displayPerformance(int iterations) {
        System.out.println("  String:"+ stringConcatenation(iterations));
        System.out.println("  StringBuilder:" + stringBuilderConcatenation(iterations));
        System.out.println("  StringBuffer: "+ stringBufferConcatenation(iterations));
    }

    public static double stringConcatenation(int iterations) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        long endTime = System.nanoTime();
        // Convert nanoseconds to seconds
        return (double)(endTime - startTime) / 1000000.0;
    }

    public static double stringBuilderConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("a");
        }
        // Ensure the string is materialized
        stringBuilder.toString();
        long endTime = System.nanoTime();
        // Convert nanoseconds to seconds
        return (double)(endTime - startTime) / 1000000.0;
    }

    public static double stringBufferConcatenation(int iterations) {
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("a");
        }
        // Ensure the string is materialized
        stringBuffer.toString();
        long endTime = System.nanoTime();
        // Convert nanoseconds to seconds
        return (double)(endTime - startTime) / 1000000.0;
    }
}