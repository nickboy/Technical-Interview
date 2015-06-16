public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || target == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length -1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return m;
            }
            
            //check if target is less or equal to nums[r]
            if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // if nums[m] >= nums[r] which means left half is sorted.
                //remember equal sign
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}