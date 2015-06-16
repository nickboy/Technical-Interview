public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        // pre for total number of unique elements in the nums array
        // cur for the pointer
        // occur for current occurance for current number;
        int pre = 1;
        int cur = 1;
        int occur = 1;
        while (cur < len) {
            if (nums[cur] == nums[cur - 1]) {
                // if number of occurance is greater than 2
                // then move to next element
                if (occur >= 2) {
                    cur++;
                    //skip the swap and moving pointers.
                    continue;
                } else {
                    // Found the duplicate at very first time.
                    // Just increase occur by one.
                    occur++;
                }
            } else {
                // reset the occurance for this non duplicate element
                occur = 1;
                
            }
            // overwrite the element in the array
            nums[pre] = nums[cur];
            pre++;
            cur++;
        }
        return pre;
    }

    public void main() {
        Solution sol = new Solution;
        int[] nums = [1,1,1,2,2,3];
        sol.removeDuplicates(nums);
    }
}