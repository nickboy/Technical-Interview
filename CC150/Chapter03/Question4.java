package com.nickboy.cc150.chapter3;
import java.util.Stack;


/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with
 * disks sorted in ascending order of size from top to bottom (i.e., each disk
 * sits on top of an even larger one). You have the following constraints: (1)
 * Only one disk can be moved at a time. (2) A disk is slid off the top of one
 * tower onto the next tower. (3) A disk can only be placed on top of a larger
 * disk. Write a program to move the disks from the first tower to the last
 * using stacks.
 * 
 * Note: the disks are numbered as 1, 2, and 3.
 */
//  O(2^n) space, O(2^n) time

//class Question4 means class tower

public class Question4 {

	private Stack<Integer> disks;
	private int index;
	public Question4(int i) {
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Question4 t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}

	public void moveDisks(int n, Question4 destination, Question4 buffer) {
		if (n > 0) {
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}

}

