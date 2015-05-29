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


	//Convert Integer to String
	public static final int MAX_DIGITS = 10;

	public static String intToStr( int num ) {
		int i = 0;
		boolean isNeg = false;
		//buffer big enough for largest int and - sign
		char[] temp = new char[MAX_DIGITS + 1];

		if(num < 0) {
			num = -num;
			isNeg = true;
		}

		while( num != 0 ) {
			temp[i++] = (char) ((num% 10) + '0');
			num /= 10;
		}
		StringBuilder b = new StringBuilder();
		if( isNeg )
			b.append( '-' );
		//start from the end
		while(i > 0) {
			b.append( temp[--i]);
		}
		return b.toString();
	}
	

}