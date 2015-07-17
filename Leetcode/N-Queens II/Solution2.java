public class Solution2 {
    int res = 0;
    public int totalNQueens(int n) {
        if (n == 0) {
            return res;
        }
        helper(new ArrayList<Integer>(), n);
        return res;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (i - cols.get(i) == row - col) {
                return false;
            }
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    
    private void helper(ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                helper(cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }
}