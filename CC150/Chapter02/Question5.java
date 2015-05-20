package com.nickboy.cc150.chapter2;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1s digit
 * is at the head of the list. Write a function that adds the two numbers and
 * return the sum as a linked list.
 * 
 * 
 */


public class Question5 {

	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		public LinkedListNode(int elem) {
			this.data = elem;
		}
  	}

	public LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2, int carry) {
		if (list1 == null && list2 == null && carry == 0)
			return null;

		LinkedListNode result = new LinkedListNode(carry);

		int value = carry;
		if (list1 != null) {
			value += list1.data;
		}
		if (list2 != null) {
			value += list2.data;
		}

		result.data = value % 10;

		//recursion
		if (list1 != null || list2 != null || value >= 10) {
			LinkedListNode more = addLists(list1 == null ? null : list1.next,
				list2 == null ? null : list2.next,
				value >= 10 ? 1:0);
			result.next = more;
		}
		return result;
	}



}