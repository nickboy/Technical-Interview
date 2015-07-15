public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tempRes = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        
        if (nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        helper(res, tempRes, nums, used);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tempRes, int[] nums, boolean[] used) {
        if (tempRes.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempRes));
            return;
        }
        
        for (int i = 0; i < nums.length; i++ ) {
            //要確定是從第一個取，若不是從第一個取，則加判斷是否前一個已取過了，
            //若是則skip，否則加入接著繼續recursion
            if (used[i] || i != 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }
            used[i] = true;
            tempRes.add(nums[i]);
            helper(res, tempRes, nums, used);
            tempRes.remove(tempRes.size() - 1);
            used[i] = false;
        }
    }
    
    
}