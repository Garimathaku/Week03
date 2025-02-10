package com.week3.day4.stringbuffer;

public class CompareStringBufferWithStringBuilder {

    // Method to measure performance of StringBuilder
    public static long measureStringBuilderTime() {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < 1000000; i++) {
            sb.append("Test");
        }
        return System.nanoTime() - startTime;
    }

    // Method to measure performance of StringBuffer
    public static long measureStringBufferTime() {
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < 1000000; i++) {
            sbf.append("Test");
        }
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        long stringBuilderTime = measureStringBuilderTime();
        long stringBufferTime = measureStringBufferTime();

        System.out.println("StringBuilder Time: " + stringBuilderTime + " ns");
        System.out.println("StringBuffer Time: " + stringBufferTime + " ns");
    }
}
