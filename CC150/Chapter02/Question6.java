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


 		while(fast != null && fast.next != null) {
 			slow = slow.next;
 			fast = fast.next.next;
 			//slow and fast meet somewhere in the loop
 			if (slow == fast) {
 				break;
 			}
 		}

 		//check if slow and fast meet or not.
 		//if no, there is no loop.
 		//if yes, there is a loop.
 		//check if fast reached the end of the list.
 		if (fast == null || fast.next == null) {
 			return null;
 		}

 		//move slow to the head
 		slow = head;
 		//move fast and slow in same speed.
 		while(slow !=fast){
 			slow = slow.next;
 			fast = fast.next;
 		}
 		return fast;

 	}


}