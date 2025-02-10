package com.week3.day4.linearsearch;

import java.util.Scanner;
public class SearchSpecificElement {
    public static String findSentenceWithWord(String[] sentences,String word){
        for(String sentence: sentences){
            if(sentence.toLowerCase().contains(word.toLowerCase())){
                return sentence;
            }
        }
        return "not found";
    }
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        //taking input from the user for string size and sentence
        System.out.println("enter the number of sentences: ");
        int size=sc.nextInt();
        sc.nextLine();
        String[] sentences= new String[size];

        for(int i=0;i<size;i++){
            sentences[i]= sc.nextLine();

        }
        //taking word as input
        String word=sc.nextLine();

        String result= findSentenceWithWord(sentences,word);

        //printing the result
        if (result.equals("Not Found")) {
            System.out.println("No sentence contains the word '" + word + "'.");
        } else {
            System.out.println("First sentence containing '" + word + "': " + result);
        }

        sc.close();

    }
}
