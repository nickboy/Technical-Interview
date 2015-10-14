public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return res;
        }
        
        int start = 0;
        int end = 0;
        int sum = A[0];
        int max = A[0];
        int totalSum = A[0];
        res.add(0);
        res.add(0);
        
        for (int i = 1; i < A.length; i++) {
            if (sum < 0) {
                start = i;
                sum = A[i];
            } else {
                sum += A[i];
            }
            end = i;
            
            if (sum > max) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
            
            totalSum += A[i]; // for latter use.
        }
        
        int[] negativeA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            negativeA[i] = -A[i];
        }
        
        start = 0;
        end = 0;
        sum = negativeA[0];
        for (int i = 1; i < negativeA.length; i++) {
            if (sum < 0) {
                start = i;
                sum = negativeA[i];
            } else {
                sum += negativeA[i];
            }
            end = i;
            
            if (totalSum + sum > max) {
                max = totalSum + sum;
                res.set(0, end + 1);
                res.set(1, start - 1);
            }
        }
        
        return res;
        
        
        
    }
}
