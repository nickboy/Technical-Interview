



public class InsertionSort {
	public void insertionSort( int[] data ) {
		for( int which = 1; which < data.length; which++) {
			int val = data[which];

			for( int i = 0; i < which; ++i) {
				if( data[i] > val) {
					System.arraycopy( data, i, data, i+1, which -i); //move data 
					data[i] = val;
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] data = {3,5,1,2,4};
		InsertionSort insSort = new InsertionSort();
		insSort.insertionSort(data);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);

		}
		System.out.println("");
	}
}

