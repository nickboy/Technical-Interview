package com.nickboy.cc150.chapter1;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters.
 * 
 * For example, the string 'aabcccccaaa' would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your
 * method should return the original string.
 * 
 */
public class Question5 {

	//first approach, but it does not consider 
	//if the length of compressed string is longer than original one.
	//Space O(N), Time O(N)
	public String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++)) {
			count++;
		} else {
			mystr += last + "" + count;
			last = str.charAt(i);
			count = 1;
		}
		return mystr + last + count;
	}


	//Second approach, use StringBuffer and determine the length of compressed string.
	public compressBetter(String original) {
		if (original == null || original.length() <= 1) {
			return original;
		}

		StringBuilder sb = new StrinbBuilder();

		char curChar = original.charAt(0);
		int count = 1;
		for(int i = 1; i < original.length(); i++) {
			char ch = original.charAt(i)
			if(curChar == ch) {
				count++;
			} else {
				sb.append(curChar);
				sb.append(count);
				curChar = ch;
			}
		}
		sb.append(curChar);
		sb.append(count);

		if (sb.length() < original.length()) {
			return sb.toString();
		} else {
			return original;
		}
	}


}