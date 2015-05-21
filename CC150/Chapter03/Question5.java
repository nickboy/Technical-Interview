package com.nickboy.cc150.chapter3;
import java.util.Stack;


/**
 * Implement a class which implements a queue using two stacks.
 */
// O(n) space, O(n) time

public class Question5<T> {
	Stack<T> stackNewest, stackOldest;

	public Question5 {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		//push to stackNewest
		stackNewest.push(value);
	}

	//move elements from stackNewest to stackOldest,
	//make sure stackOldest has element to pop or peek.
	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}

	public T pop() {
		shiftStacks();
		return stackOldest.pop();
	}
}

