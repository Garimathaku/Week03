package com.day2.stackandqueue;
import java.util.*;

public class SortStackUsingRecursion {
    //method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertSorted(stack, top);
        }
    }

    //  method to insert sorted element
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }

    }

    public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
        //push the element into the stack
            stack.push(3);
            stack.push(4);
            stack.push(1);
            stack.push(2);
            stack.push(5);
         //print the stack
            System.out.println("Original Stack: " + stack);
            sortStack(stack);
            System.out.println("Sorted Stack: " + stack);

        }
    }


