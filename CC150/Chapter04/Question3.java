package com.nickboy.cc150.chapter4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary search tree with minimal height.
 * 
 */
public class Question3 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode createMinimalBST(int arr[], int start, int end) {
		if(end<start)
			return null;
		int mid = (end - start) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createMinimalBST(arr[], start, mid -1]);
		node.right = createMinimalBST(arr[], mid + 1, end);

		return node;

	}

	TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

}

