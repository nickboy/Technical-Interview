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
 		//the number of list is odd, skip the middle one.
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

 	
 	//for recursive approach
	public static class Result {
		public LinkedListNode node;
		public boolean result;
	}

 	Result isPalindromeRecurse(LinkedListNode head, int length) {

 		//if number of nodes is less then 3, do the comparison directly.
 		if (head == null || length == 0) {
 			return new Result(null, true);
 		} else if (length == 1) {
 			return new Result(head.next,true);
 		} else if (length == 2) {
 			return new Result(head.next.next,
 				head.data == head.next.data);
 		}

 		Result res = isPalindromeRecurse(head.next, length - 2);
 		if (!res.result || res.node == null) {
 			return res;
 		} else {
 			res.result = (head.data == res.node.data);
 			res.node = res.node.next;
 			return res;
 		}
 	}

 	boolean isPalindrome (LinkedListNode head) {
 		Result p = isPalindromeRecurse(head, listSize(head));
 		return p.result;
 	}

}

