package com.nickboy.cc150.chapter1;

/**
 * Assume you have a method isSubString which checks if one word is substring of
 * another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a
 * rotation of "erbottlewat")
 * 
 */
//space O(1), time O(1)

public class Question8 {
	//if is true then s2 must be a substring of s1s1
	public boolean is Rotation(String s1, String s2) {
		if (s1.length != s2.length)
			return false;
		if(s1.length == s2.length && s1.length > 0) {
			string s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}

	public boolean isSubstring(String haystack, String needle) {
		return haystack.contains(needle);
	}
}