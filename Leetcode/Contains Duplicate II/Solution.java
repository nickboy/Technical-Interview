public class Solution {
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            //if i greater then k remove items from set
            if ( i > k)
                set.remove(nums[i-k-1]);
            //add item into set. if there is something exists, return false;
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}