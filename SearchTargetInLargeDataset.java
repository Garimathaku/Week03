package com.week3.day5;

import java.util.Random;
import java.util.*;
public class SearchTargetInLargeDataset {
    //create a method to generate random array
    public static int[] randomArrayGenerator(int n){
        Random random= new Random();
        int []randomArray= new int[n];
        for(int i=0;i<n;i++){
            randomArray[i]= random.nextInt(n);
        }
        return randomArray;

    }
    //create a method to search target in linear search
    public static boolean linearSearch(int []arr,int target){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }
    //create a method to search target in linear search
    public static boolean binarySearch(int []arr,int target){

        int start=0;
        int end=arr.length-1;
        while(start<=end) {
            int mid = start + ((end - start) / 2);
            if(target==arr[mid]){
                return true;
            }else if(target<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;

    }
    //method to calculate performance of linear search
    public static void linearCalculatePerformance(int []arr,int target) {
        long startTime = System.nanoTime();

        linearSearch(arr, target);
        long endTime = System.nanoTime();

        System.out.println("Linear Search Time: " + (endTime - startTime) / 1000000.0 + "ms");
    }
   //method to calculate performance of binary search
        public static void binaryCalculatePerformance(int []arr,int target){
          Arrays.sort(arr);
       long startTime1= System.nanoTime();

        binarySearch(arr,target);
        long endTime1= System.nanoTime();

        System.out.println("Binary Search Time: "+(endTime1-startTime1)/1000000.0+ "ms");

    }
    //main method
    public static void main(String[]args){
        int []dataSize={1000,10000,1000000};
        Random random= new Random();
        for(int data:dataSize) {
            System.out.println("Dataset Size" + data);
            int[] arr = SearchTargetInLargeDataset.randomArrayGenerator(data);
            int target = arr[random.nextInt(data)];

            //call methods
            SearchTargetInLargeDataset.linearCalculatePerformance(arr, target);
            Arrays.sort(arr);//sort the array
            SearchTargetInLargeDataset.binaryCalculatePerformance(arr, target);
        }
    }
}
