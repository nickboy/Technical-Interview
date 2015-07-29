public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int min = nums.get(0);
        int cur = nums.get(0);
        // 與Maximum Subarray 大同小異，但在這裡要比的是當下的值是否比cur+當下值來得小，
        // 若是，則直接從當下值重新開始算
        // 若否，則把當下值累積繼續下一步
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < cur + nums.get(i)) {
                cur = nums.get(i);
            } else {
                cur += nums.get(i);
            }
            min = Math.min(cur, min);
        }    
        return min;
    }
}

