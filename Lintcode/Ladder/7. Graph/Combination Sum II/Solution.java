public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0 || target == 0) {
            return res;
        }
        Arrays.sort(num);
        helper(num, target, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] num, int target, int pos, List<List<Integer>> res, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }

        //仍然使用prev來記錄前一個值
        int prev = -1;
        for (int i = pos; i< num.length; i++) {
            if (target < num[i]) {
                break;
            }
            
            //因為每個值只能使用一次，因次call helper時，得用i+1。
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            path.add(num[i]);
            helper(num, target - num[i], i+1, res, path);
            path.remove(path.size() - 1);
            prev = num[i];
        }
    }
}
