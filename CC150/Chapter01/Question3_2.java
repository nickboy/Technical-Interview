package com.nickboy.cc150.chapter1;

import java.util.Arrays;
/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * 
 */
//  O(1) space, O(n) time, count the number for each character. 
//  Assume it is ASCII code which only have 256 chars.
public class Question3_2 {
	public boolean permutation(String s, String t) {
		if(s.length() != t.length())
			return false;
		char[] table = new char[256];

		char[] s_array = s.toCharArray();
		//count the number for each character in s.
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0 ) {
				return false;
			}
		}

		return true;

	}
}