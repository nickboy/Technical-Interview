package com.nickboy.cc150.chapter1

import java.util.Arrays;
/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * 
 */
//  O(1) space, O(nlogn) time, sort two strings then do the comparison
public class Question3_1 {
	public boolean permutation(String s, String t){
		if(s.length != t.length)
			return false;
		return sort(s).equals(sort(t));
	}

	public String sort(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}