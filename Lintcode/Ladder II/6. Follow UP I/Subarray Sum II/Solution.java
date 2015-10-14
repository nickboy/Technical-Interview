public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] sumArray = new int[A.length];
        sumArray[0] = 0;
        int sum = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i - 1];
            sumArray[i] = sum;
        }
        
        int count = 0;
        for (int i = 0; i <= A.length; i++) {
            for (int j = i; j <= A.length; j++) {
                int diff = sumArray[j] - sumArray[i];
                if (diff >= start && diff <= end) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
