package com.week3.day4.inputstreamreader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertByteStreamToCharacterStream {

    // Method to convert byte stream to character stream and read file
    public static void readFileUsingByteStream(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/day4/test.txt";

        // Call method to read file using byte stream conversion
        readFileUsingByteStream(filePath);
    }
}
