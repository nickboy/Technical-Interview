public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<Integer>();
        
        if (nums.length == 0) {
            return result;
        }
        //Array should be sorted in non-descending order.
        Arrays.sort(nums);
        helper(result, tempResult, nums, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, 
                        List<Integer> tempResult, 
                        int[] nums, 
                        int pos) {
        result.add(new ArrayList<Integer>(tempResult));
        
        for (int i = pos; i < nums.length; i++) {
            tempResult.add(nums[i]);
            helper(result, tempResult, nums, i + 1);
            tempResult.remove( tempResult.size() - 1);
        }
    }
}