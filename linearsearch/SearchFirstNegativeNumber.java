package com.week3.day4.linearsearch;

import java.util.Scanner;
public class SearchFirstNegativeNumber {
    public static int findFirstNegative(int[]arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                //Return index of the first negative number
                return i;
            }
        }
        //return -1 if no negative number is found
        return -1;
    }
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        //taking array size input
        int size= sc.nextInt();
        int []numbers= new int[size];
        //taking array element input
        for(int i=0;i<size;i++) {
            numbers[i] = sc.nextInt();

        }
            int idx= findFirstNegative(numbers);

            if(idx!=-1){
                System.out.println("First negative number is  found at index: "+ idx);
                System.out.println("Negative number: "+ numbers[idx]);

           }else{
                System.out.println("No negative found in  the array");
            }
        }
    }

