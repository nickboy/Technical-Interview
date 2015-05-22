package com.nickboy.cc150.chapter3;
import java.util.Stack;


/**
 * Write a program to sort a stack in ascending order (with biggest items on
 * top). You may use additional stacks to hold items, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 * 
 */
// O(n) space, O(n^2) time

public class Question6 {

	public static Stack<Integer> sort (Stack<Integer> s) {
		//create a second stack for sorted elements
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();

			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

}

