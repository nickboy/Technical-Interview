package com.nickboy.cc150.chapter1;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0. Do this in place.
 * 
 */
// O(1) space, O(n) space, n is size of matrix

public class Question7 {

	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		//scan whole matrix and indicate which row and column need to be empty.
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		//empty whole row or column when row[i] or column[j] is true.
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}