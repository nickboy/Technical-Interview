public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();
        if (candidates.length == 0 || target == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, currentList);
        return result;
    }
    
    private void helper(int[] candidates, int target, int pos, List<List<Integer>> result, List<Integer> currentList) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(currentList));
        } else {
            for (int i = pos; i < candidates.length; i++) {
                int tempResult = target - candidates[i];
                if (tempResult >= 0) {
                    currentList.add(candidates[i]);
                    helper(candidates, tempResult, i, result, currentList);
                    currentList.remove(currentList.size() - 1);
                    
                }
            }
        }
    }
}