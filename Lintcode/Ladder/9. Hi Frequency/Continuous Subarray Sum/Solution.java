public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (A == null || A.length == 0) {
            return res;
        }
        
        // 先假設目前最大值為第一個元素
        int sum = A[0];
        int max = sum;
        int start = 0;
        int end = 0;
        res.add(0);
        res.add(0);
        
        for (int i = 1; i < A.length; i++) {
            if (sum > max) {
                res.set(0, start);
                res.set(1, i - 1);
                max = sum;
            }
            
            //如果加起來更小的話，則捨棄前面的和，直接從目前這個元素開始
            if (sum < 0) {
                sum = 0; 
                start = i;
                end = i;
            }
            sum += A[i];
        }
        
        // 因上面的循環總是在下一次才把上一輪的結果加上，因此最後還需再判斷一次。
        if (sum > max) {
            res.set(0, start);
            res.set(1, A.length - 1);
        }
        
        return res;
    }
}
