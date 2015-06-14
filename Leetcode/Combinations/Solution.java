//Time O(2^n)

public class NaiveSolution {
    
    private Set<Integer> set = new HashSet<Integer>();
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private boolean[] used;
    
    public List<List<Integer>> combine(int n, int k) {
        set = new HashSet<Integer>();
        result = new ArrayList<List<Integer>>();
        used = new boolean[n];
        if (n == 0 || k == 0) {
            return result;
        }
        helper(n, k);
        return result;
    }
    
    private void helper(int n, int k) {
        if (set.size() == k) {
            result.add(new ArrayList<Integer>(set));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i-1]) {
                continue;
            }
            set.add(i);
            used[i-1] = true;
            helper(n,k);
            set.remove(i);
            used[i-1] = false;
        }
    }
}