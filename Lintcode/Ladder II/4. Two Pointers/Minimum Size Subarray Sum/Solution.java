public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; i < nums.length; i++) {

            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
            
            sum -= nums[i];
        }
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
        
    }
}
