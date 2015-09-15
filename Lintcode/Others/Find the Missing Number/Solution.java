public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int total = len * (len + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        return total - sum;
    }

    public int findMissing(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int total = len * (len + 1) / 2;
        int xorOne = nums[0];
        for (int i = 1; i < len; i++) {
            xorOne ^= nums[i];
        }
        
        int xorTwo = 1;
        for (int i = 2; i <= len; i++) {
            xorTwo ^= i;
        }
        
        return xorTwo ^ xorOne;
    }
}
