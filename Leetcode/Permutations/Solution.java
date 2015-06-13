public class Solution {
    boolean[] used;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> tempResult = new ArrayList<Integer>();
    int len;
    
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        if (len == 0) {
            return result;
        }
        used = new boolean[len];
        helper(nums);
        return result;
    }
    
    private void helper(int[] nums) {
        if (tempResult.size() == len) {
            //remember to new an ArrayList object 
            //otherwise the result will be overwrite
            result.add(new ArrayList<Integer>(tempResult));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            tempResult.add(nums[i]);
            helper(nums);
            tempResult.remove(tempResult.size() - 1);
            used[i] = false;
        }
    }
}