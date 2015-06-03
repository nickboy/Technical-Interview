package com.nickboy.pie.chapter8;
import java.util.ArrayList;
import java.util.List;



public class SelectionSort {
	public void selectionSortRecursive( int[] data ) {
		selectionSortRecursive( data, 0 );
	}

	// Sort a subset of the array starting at the given index.
	private void selectionSortRecursive( int[] data, int start) {
		if (start < data.length - 1) {
			swap( data, start, findMinimumIndex( data, start));
			selectionSortRecursive( data, start + 1);
		}
	}

	// Find the position of the minimum value starting at the given index.
	private int findMinimumIndex( int[] data, int start ) {
		int minPos = start;
		for(int i = start + 1; i <data.length; ++i) {
			if(data[i] < data[minPos]) {
				minPos = i;
			}
		}
		return minPos;
	}

	//swap two elements in an array
	private void swap( int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}

