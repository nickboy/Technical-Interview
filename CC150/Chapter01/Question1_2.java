package com.nickboy.cc150.chapter1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * 
 */
//      use bit vector which can reduce space to 1/8.

public class Question1_2 {
	public boolean isUniqueChars(String str){
		if (str.length() > 256) return false;

		int checker = 0;
		for (int i = 0; i <str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return false;
	}
}