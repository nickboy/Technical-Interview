public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int count = 1;
        int max = 1;
        for(int i = 1; i < A.length; i++) {
            if (A[i - 1] <= A[i]) {
                count++;
                max = count > max ? count : max;
            } else {
                count = 1;
            }
        } 
        
        count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] >= A[i]) {
                count++;
                max = count > max? count : max;
            } else {
                count = 1;
            }
        }
        
        return max;
    }
}
