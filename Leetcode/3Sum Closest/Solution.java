public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length - 1;
        int closest = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            l = i+1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } 
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closest;
    }
}