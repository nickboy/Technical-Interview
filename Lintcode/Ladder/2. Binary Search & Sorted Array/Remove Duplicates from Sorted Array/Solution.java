public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        //use two pointer approach
        //first pointer point to last non duplicate element
        //second pointer travse whole list.
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                pos += 1;
                nums[pos] = nums[i];
            }
        }
        // since index is start from 0
        return pos + 1;
    }
}
