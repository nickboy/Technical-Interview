public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> tempRes, int pos) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tempRes));
            return;
        }
        
        //因起始位置不是從0開始，因此只能用個prev來開始
        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }
            tempRes.add(candidates[i]);
            //此處用i，因可以重復取，若是像之前的subset，就得用i+1。
            helper(candidates, target - candidates[i], res, tempRes, i);
            tempRes.remove(tempRes.size() - 1);
            
            prev = candidates[i];
        }
    }
}
