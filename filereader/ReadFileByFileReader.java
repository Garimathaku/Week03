package com.week3.day4.filereader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByFileReader {

    // Method to read and print file contents
    public static void readFile(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/day4/test.txt";

        // Call method to read the file
        readFile(filePath);
    }
}
