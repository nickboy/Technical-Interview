package com.nickboy.pie.chapter6;



class IntegerStringConverter {
	
	public static int strToInt( String str) {
		int i = 0, num = 0;
		boolean isNeg = false;
		int len = str.length();

		if( str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}

		while( i < len) {
			num *= 10;
			num += (str.charAt(i++) - '0'); //convert ascii to int
		}
		if( isNeg)
			num = -num;
		return num;
	}
	

}