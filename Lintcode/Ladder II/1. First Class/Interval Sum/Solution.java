/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        
        ArrayList<Long> res = new ArrayList<Long>();
        
        if (A == null || A.length == 0 || queries == null || queries.size() == 0) {
            return res;
        }
        
        long[] sum = new long[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = A[i] + sum[i-1];
        }
        
        for (int i = 0; i < queries.size(); i++) {
            Interval cur = queries.get(i);
            int start = cur.start;
            int end = cur.end;
            long curRes;
            
            if (start >= 0 && start < A.length && end >= 0 && end < A.length) {
                if (start == 0) {
                    curRes = sum[end];
                } else {
                    curRes = sum[end] - sum[start - 1];
                }
                res.add(curRes);
            }    
        }
        
        return res;
    }
}

