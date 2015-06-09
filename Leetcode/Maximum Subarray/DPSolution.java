public class DPSolution {
    
    public int maxSubArray(int[] nums) {
        
        int length = nums.length;
        
        if (length == 0) {
            return 0;
        }
        
        int maxSum = nums[0];
        int current = nums[0];
        
        for (int i = 1; i < length; i++) {
            if (current < 0) {
                current = nums[i];
            } else {
                current += nums[i];
            }
            maxSum = current > maxSum ? current:maxSum;
        }
        
        return maxSum;
    }
}