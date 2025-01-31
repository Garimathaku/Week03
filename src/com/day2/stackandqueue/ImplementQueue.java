package com.day2.stackandqueue;


import java.util.*;


class QueueUsingStack{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    QueueUsingStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();

    }
   //method to add the element to the last
    public void enqueue(int x){
        stack1.push(x);
    }
    //method to remove from the top element
    public int dequeue(){
        peek();
        return stack2.pop();
    }
    //method to check the top element
    public int peek(){
        if(stack2.empty())
        while(!stack1.empty())
            stack2.push(stack1.pop());
        return stack2.peek();

    }
    //method to check if the stack in empty
    public boolean empty(){
        return stack1.empty()&& stack2.empty();
    }
}
public class ImplementQueue {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.empty());
    }
}

