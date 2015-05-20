package com.nickboy.cc150.chapter2;

/**
 * Assume you have a method isSubString which checks if one word is substring of
 * another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a
 * rotation of "erbottlewat")
 * 
 */


public class Question8 {
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