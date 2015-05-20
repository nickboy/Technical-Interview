package com.nickboy.cc150.chapter1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * 
 */
//      use an array to store, O(1) space and O(n) time

public class Question1 {
	public boolean isUniqueChars2(String str){
		if(str.length() > 256)
			return false;
		boolean[] table = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(table[val])
				return false;
			table[val] = true;
		}
		return true;
	}
}