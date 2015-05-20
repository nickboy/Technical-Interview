package com.nickboy.cc150.chapter1;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees (clockwise). Can
 * you do this in place?
 * 
 */
// O(1) space O(n^2) time

public class Question6 {

	public void rotate(int[][] matrix) {

		//rotate layer by layer, from outter to inner.
		for (int layer = 0; layer < matrix.length / 2; layer++){
			int first = layer;
			int last = matrix.length - layer - 1;

			for(int i = first; i < last; ++i) {
				int offset = i - first;

				//save top
				int top = matrix[first][i];

				//left to top
				matrix[first][i] = matrix[last - offset][first];
				//bottom to left
				matrix[last-offset][first] = matrix[last][last - offset];
				//right to bottom
				matrix[last][last - offset] = matrix[i][last];
				//top to right
				matrix[i][last] = top;
			}
		}

	}

}