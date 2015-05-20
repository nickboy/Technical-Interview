package com.nickboy.cc150.chapter1;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters, and that you are given the "true" length of the
 * string.
 * 
 */
//  O(n) space, O(n) time
public class Question4_2 {
	public void replaceSpaces(char[] str, int length) {
		int pos = input.length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (input[i] == ' ') {
				input[pos--] = '0';
				input[pos--] = '2';
				input[pos--] = '%';
			}
			input[pos--] = input[i];
		}
		
	}
}