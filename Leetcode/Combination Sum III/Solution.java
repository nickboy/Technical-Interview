public class Solution {
    private int number;
    private int size;
    public List<List<Integer>> combinationSum3(int k, int n) {
        number = n;
        size = k;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), 0, 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, 
                        ArrayList<Integer> tempRes,
                        int cur,
                        int pos) {
        if (tempRes.size() == size && number == cur) {
            res.add(new ArrayList<Integer>(tempRes));
            return;
        }
        //記住，要看清題目，只能用到9，而非n
        for (int i = pos; i <= 9; i++) {
            if (cur + i <= number) {
                tempRes.add(i);
                helper(res, tempRes, cur + i, i+1);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }
}