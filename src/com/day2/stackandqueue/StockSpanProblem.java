package com.day2.stackandqueue;
import java.util.*;

public class StockSpanProblem {
   //method stockSpan
    public static void stockSpan(int s[], int price[], int n) { // Made static
        Stack<Integer> st = new Stack<>();
        st.push(0);
        s[0] = 1;
         //iterating in loop
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            s[i] = (st.isEmpty() ? (i + 1) : i - st.peek());
            st.push(i);
        }
    }
//main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price[] = new int[n];
        int s[] = new int[n]; // Initialize the span array

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        stockSpan(s, price, n);

        // Output the span values
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }

        sc.close(); // Close Scanner
    }
}
