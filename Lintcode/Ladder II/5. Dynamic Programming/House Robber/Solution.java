public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        
        if (A == null || A.length <= 3) {
            if (A == null || A.length == 0) {
                return 0;
            } else if (A.length == 1) {
                return A[0];
            } else if (A.length == 2) {
                return Math.max(A[0], A[1]);
            } else if (A.length == 3) {
                return  Math.max((A[0] + A[2]), A[1]);
            }
        }
        
        int len = A.length;
        long[] profit = new long[len];
        profit[0] = A[0];
        profit[1] = Math.max(A[0], A[1]);
        profit[2] = Math.max((A[0] + A[2]), A[1]);
        
        for (int i = 3; i < len; i++) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + A[i]);
        }
        
        return profit[len-1];
    }
}
