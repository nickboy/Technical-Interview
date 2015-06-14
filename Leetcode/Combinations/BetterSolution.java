//Similar to permutation.
//but just start from next number


public class BetterSolution {
    
    private List<Integer> tempResult;
    private List<List<Integer>> result;
    
    public List<List<Integer>> combine(int n, int k) {
        tempResult = new ArrayList<Integer>();
        result = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return result;
        }
        helper(n, k, 1);
        return result;
    }
    
    private void helper(int n, int k, int start) {
        if (tempResult.size() == k) {
            result.add(new ArrayList<Integer>(tempResult));
            return;
        } else {
            //remember to use else, otherwise program will have recompute result.
            for (int i = start; i <= n; i++) {
                tempResult.add(i);
                helper(n, k, i + 1);
                tempResult.remove(tempResult.size() - 1);
            }
        }
        
    }
}