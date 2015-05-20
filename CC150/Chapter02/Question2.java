package com.nickboy.cc150.chapter2;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list.
 * 
 */
// O(1) space, O(n) time


public class Question2 {

	public static class LinkedListNode {
    	public int elem;
    	public LinkedListNode next;
    	public LinkedListNode(int elem) {
      		this.elem = elem;
    	}
  	}

	LinkedListNode nthToLast(LinkedListNode head, int k) {
		if (k <= 0) return null;

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		//move p2 k-1 steps first.
		for (int i = 0; i <k-1; i++) {
			//means k is greater than the length of list.
			if(p2 == null) return null;
			p2 = p2.next;
		}
		//means k is greater than the length of list.
		if (p2 == null) return null;

		//move p1 and p2 in same speed.
		while(p2 != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
}