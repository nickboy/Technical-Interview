public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();
        int[] left = new int[len];
        int[] right = new int[len];
        
        //此為sell stock 的變型
        
        //算左半邊的max subarray
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        
        //算右半邊的max subarray
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum); //是比sum - minSum 
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        //算出兩者總合最大的
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, left[i] + right[i+1]);
        }
        
        return max;
    }
}


