package com.week3.day4.stringbuilder;

public class ReverseString {
    public static String reverseString(String str){
        StringBuilder sbr=new StringBuilder();
        sbr.append(str);

        //use reverse() method to reverse the string
        StringBuilder reverse= sbr.reverse();
        return reverse.toString();
    }
    public static void main(String[]args){
        //create a object of StringBuilder and append input string

        String rev=reverseString("Hello");
      //print the output
        System.out.println("Reverse String: "+rev);
    }
}
