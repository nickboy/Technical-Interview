package com.nickboy.cc150.chapter2;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
 * 
 */
// O(n) space, O(n) time


public class Question4 {

	public static class LinkedListNode {
    	public int data;
    	public LinkedListNode next;
    	public LinkedListNode(int elem) {
      		this.data = elem;
    	}
  	}

  	public LinkedListNode partition(LinkedListNode node, int x) {
  		LinkedListNode beforeStart = null;
  		LinkedListNode beforeEnd = null;
  		LinkedListNode afterStart = null;
  		LinkedListNode afterEnd = null;


  		//split linked list
  		while (node != null) {
  			LinkedListNode next = node.next;
  			node.next = null;

  			if (node.data < x) {
  				//insert current right after before list
  				if (beforeStart == null) {
  					beforeStart = node;
  					beforeEnd = beforeStart;
  				} else {
  					beforeEnd.next = node;
  					beforeEnd = node;
  				}
  			} else {
  				//if after list is empty create a head pointed by afterStart
  				if (afterStart == null) {
  					afterStart = node;
  					afterEnd = beforeStart;
  				} else {
  					afterEnd.next = node;
  					afterEnd = node;
  				}
  			}
  			node = next;
  		}

  		if (beforeStart == null) {
  			return afterStart;
  		} 
  		//merge two lists.
  		beforeEnd.next = afterStart;
  		return beforeStart;
  	}



}