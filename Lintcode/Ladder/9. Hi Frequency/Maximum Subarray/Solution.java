public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        //解法：先把第一個數加入current與設為max
        //      接著就一直不斷的先判斷current再決定丟棄前面的結果
        //      或是原本結果加上新的數
        int max = nums.get(0);
        int current = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (current < 0) {
                current = nums.get(i);
            } else {
                current += nums.get(i);
            }
            max = (current > max) ? current : max;
        }
        return max;
    }
}
