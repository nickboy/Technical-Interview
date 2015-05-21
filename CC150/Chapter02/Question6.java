package com.nickboy.cc150.chapter2;

/**
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * 
 * EXAMPLE Input: A-> B -> C -> D -> E -> C [the same C as earlier Output: C
 * 
 */
// O(1) space, O(n) time


public class Question6 {

	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		public LinkedListNode(int elem) {
			this.data = elem;
		}
  	}

 	boolean findLoop(LinkedListNode head) {
 		LinkedListNode fast = head;
 		LinkedListNode slow = head;

 		Stack<Integer> stack = new Stack<Integer>();


 		while(fast != null && fast.next != null) {
 			stack.push(slow.data);
 			slow = slow.next;
 			fast = fast.next.next;
 		}
 	}


}