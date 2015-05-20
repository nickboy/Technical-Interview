package com.nickboy.cc150.chapter2;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 */


public class Question2 {
	//use a dummy node previous to record previous node.
	//if the node already exists in hashtable, change the previous link to point to next node.
	//space O(n), time O(n)
	public static void deleteDups(LinkedListNode n) {
		HashTable table = new HashTable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous.next = n;
			}
			n = n.next;
		}
	}
	
	public static void deleteDupsWithoutBuffer(LinkedListNode head) {
		//use two pointer current and runner, use runner to check each node before current node.
		//space O(1), time O(n^2)
		if (head == null) return;

		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}

	}	
}