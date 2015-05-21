package com.nickboy.cc150.chapter2;
import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 */
// O(n) space, O(n) time


public class Question7 {

	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		public LinkedListNode(int elem) {
			this.data = elem;
		}
  	}

 	boolean isPalindrome_iterative(LinkedListNode head) {
 		LinkedListNode fast = head;
 		LinkedListNode slow = head;

 		Stack<Integer> stack = new Stack<Integer>();


 		while(fast != null && fast.next != null) {
 			stack.push(slow.data);
 			slow = slow.next;
 			fast = fast.next.next;
 		}

 		if (fast != null) {
 			slow = slow.next;
 		}

 		while (slow != null) {
 			int top = stack.pop().intValue();

 			if (top != slow.data) {
 				return false;
 			}

 			slow = slow.next;
 		}
 		return true;


 	}


}