package com.nickboy.cc150.chapter2;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 * 
 * 
 * EXAMPLE
 * 
 * Input: the node c from the linked list a ->b ->c ->d ->e
 * 
 * Result: nothing is returned, but the new linked list looks like a ->b ->d ->e
 * 
 */


public class Question3 {

	public static class LinkedListNode {
    	public int elem;
    	public LinkedListNode next;
    	public LinkedListNode(int elem) {
      		this.elem = elem;
    	}Í
  	}


  	//1. Copy the value of next node to current node
  	//2. Remove next node.
  	//this approach will failed if next node is null.
	public static boolean deleteNode (LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; //failed
		}

		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;

	}
}