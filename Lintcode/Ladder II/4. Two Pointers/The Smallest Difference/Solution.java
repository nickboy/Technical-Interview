public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;
        while ( i < A.length && j < B.length) {
            int curDiff = Math.abs(A[i] - B[j]);
            minDiff = (curDiff < minDiff) ? curDiff : minDiff;
            if (A[i] > B[j]) {
                j++;
            } else {
                i++;
            }
        }
        
        return minDiff;
    }
}

