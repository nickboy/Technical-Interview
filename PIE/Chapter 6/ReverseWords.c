package com.nickboy.pie.chapter6;



class ReverseWords {
	
	void wcReverseWords( wchar_t str[]) {
		int start = 0, end = 0, length;
		length = wcslen(str);

		wcReverseString(str, start, length - 1);

		while (end < length) {
			if( str[end] != L' ') {
				start = end;
				while(end < length && str[end] != L' ')
					end++;
				end--;
				wcReverseString(str, start, end);
			}
			end++;
		}
	}	

	void wcReverseString( wchar_t str[], int start, int end) {
		wchar_t temp;
		while( end > start ) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	

}