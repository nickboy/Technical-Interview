package com.nickboy.cc150.chapter3;
import java.util.Stack;


/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum elements? Push, pop and min should all
 * operate in O(1) time.
 * 
 */
public class Question2 {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int value) {
		stack.push(value);
		if(minStack.isEmpty() || minStack.peek() >= value)
			minStack.push(value);
	}

	public Integer pop() {
		int value = stack.pop();
		if (value == minStack.peek())
			minStack.pop();
		return value;

	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}

