package com.nickboy.cc150.chapter1

/**
 * Implement a function void reverse(String str) which reverses a
 * null-terminated string.
 * 
 */
// O(1) space, O(n) time
public class Question2 {
	public char[] reverse(char[] str){
		int length = str.length;
		if(str == null)
			return new char[] {};

		for (int i = 0; i < str.length / 2; i++){
			char temp = str[i];
			str[i] = str[length-i-1];
			str[length-i-1] = temp;
		}
		return str;
	}
}