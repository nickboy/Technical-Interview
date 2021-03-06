



public class MergeSort {
	
	
	public int[] mergeSortSimple( int[] data ) {
		if ( data.length < 2 ) {
			return data;
		}

		//Split the array into two subarrays of approx equal size.
		int mid = data.length / 2;
		int[] left = new int[ mid ];
		int[] right = new int [ data.length - mid];

		System.arraycopy( data, 0, left, 0, left.length );
		System.arraycopy( data, mid, right, 0, right.length );

		// Sort each subarray, then merge the result.

		mergeSortSimple( left );
		mergeSortSimple( right );

		return merge( data,left, right); 

	}

	private int[] merge( int[] dest, int[] left, int[] right ) {
		int dind = 0;
		int lind = 0;
		int rind = 0;

		// Merge arrays while there are elements in both
		while ( lind < left.length && rind < right.length ) {
			if ( left[ lind ] <= right[ rind ] ) {
				dest[ dind++] = left[ lind++ ];
			} else {
				dest[ dind++] = right [ rind++ ];
			}
		}

		// Copy rest of whichever array remains
		while ( lind < left.length )
			dest[dind++] = left[ lind++];
		while ( rind < right.length )
			dest[dind++] = right[rind++];

		return dest;
	}

	public static void main(String[] args) {
		int[] data = {3,5,1,2,4};
		MergeSort merSort = new MergeSort();
		merSort.mergeSortSimple(data);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);

		}
		System.out.println("");
	}
}

