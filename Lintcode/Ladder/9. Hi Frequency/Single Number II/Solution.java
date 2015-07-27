public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        int result = 0;
        int[] bit = new int[32];
        for (int i = 0; i <32; i++) {
            for (int j = 0; j < A.length; j++) {
                // 把A array中的每個數取出第i個binary值作相加再除以3
                bit[i] += (A[j] >> i) & 1; 
                bit[i] = bit[i] % 3;
            }
            //接著把bit合成result即可
            result = result | (bit[i] << i);
        }
        return result;
    }
}
