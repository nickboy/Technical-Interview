class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if ( nums.length == 0 ) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        //相鄰或相交就退出
        // l+1<r !=  l<=r
        while (l + 1 < r) {
            int mid = l + (r - l) / 2; //考慮越界的問題
            if ( nums[mid] == target ) {
                r = mid; //不直接return因要找第一個，找第一個則end往前靠，若是找最後一個則start往後靠
            } else if ( nums[mid] < target) {
                l = mid;
            } else if ( nums[mid] > target) {
                r = mid;
            }
        }
        //作最後的比對
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    } 
}
