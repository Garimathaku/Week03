package com.week3.day4.inputstreamreader;
import java.io.*;

public class ReadUserInputUsingInputStreamReader {

    // Method to read user input and write to file
    public static void readUserInputAndWriteToFile(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            while (!(input = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(input);
                bufferedWriter.newLine();
            }

            System.out.println("User input has been saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/day4/test.txt";

        // Call method to read user input and write to file
        readUserInputAndWriteToFile(filePath);
    }
}
