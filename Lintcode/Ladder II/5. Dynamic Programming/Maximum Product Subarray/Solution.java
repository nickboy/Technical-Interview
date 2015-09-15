public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int global = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            
            // localMax會被改變，因此得先存下來。
            int localMaxCopy = localMax;

            // 作比較時，也需與當前陣列元素作比較，來決定是否放棄前面的乘積
            localMax = Math.max(Math.max(localMax * nums[i], localMin * nums[i]), nums[i]);
            localMin = Math.min(Math.min(localMin *nums[i], localMaxCopy * nums[i]), nums[i]);
            global = Math.max(global, localMax);
        }
        
        return global;
    }
}
