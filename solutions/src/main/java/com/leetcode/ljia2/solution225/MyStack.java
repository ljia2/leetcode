package com.leetcode.ljia2.solution225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes: You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 **/

public class MyStack {
	Queue<Integer> q1;
	Queue<Integer> q2;
	MyStack(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	// Push element x onto stack.
    public void push(int x) {
        if(q1.size() == 0 && q2.size() == 0){
        	q1.add(x);
        }else if(q1.size() > 0){
        	q1.add(x);
        }else{
        	q2.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(empty()){
        	throw new RuntimeException("Can not pop an empty stack");
        }else if(q1.size() > 0){
        	while(q1.size() > 1){
        		q2.add(q1.poll());
        	}
        	q1.poll();
        }else{
        	while(q2.size() > 1){
        		q1.add(q2.poll());
        	}
        	q2.poll();
        }
    }

    // Get the top element.
    public int top() {
        if(empty()){
        	throw new RuntimeException("Can not top an empty stack");
        }else if(q1.size() > 0){
        	while(q1.size() > 1){
        		q2.add(q1.poll());
        	}
        	int rs = q1.peek();
        	q2.add(q1.poll());
        	return rs;
        }else{
        	while(q2.size() > 1){
        		q1.add(q2.poll());
        	}
        	int rs = q2.peek();
        	q1.add(q2.poll());
        	return rs;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q1.size() == 0 && q2.size() == 0){
        	return true;
        }else{
        	return false;
        }
    }
}
