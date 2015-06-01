package com.nickboy.pie.chapter7;



class BinarySearch {
	
	int binarySearch(int[] array, int target) 
			throws Exception {
		return binarySearch(array, target, 0, array.length-1);
	}

	int binarySearch( int[] array, int target, int lower, int upper) {
		int center, range;
		range = upper - lower;
		if(range < 0) {
			throw new Exception("Limits reversed");
		} else if ( range == 0 && array[lower] != target) {
			throw new Exception("Element not in array");
		}

		if( array[lower] > array[upper]) {
			throw new Exception("array not sorted");
		}

		center = ((range)/2) + lower;
		if (target == array[center]) {
			return center;
		} else if (target < array[center]) {
			return binarySearch( array, target, lower, center - 1);
		} else {
			return binarySearch( array,target,center + 1, upper);
		}
	}

}