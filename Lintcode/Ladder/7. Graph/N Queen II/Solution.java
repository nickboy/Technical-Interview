class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), n);
        return res;
    }
    
    private ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < cols.size(); i++) {
            int col = cols.get(i);
            String str = "";
            for (int j = 0; j < cols.size(); j++) {
                if (col == j) {
                    str += 'Q';
                } else {
                    str += '.';
                }
            }
            result.add(str);
        }
        
        return result;
    }
    
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // 驗證是否為同一行
            if (cols.get(i) == col) {
                return false;
            }
            
            //驗證斜角
            if (i - cols.get(i) == row - col) {
                return false;
            }
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    
    
    private void helper(ArrayList<ArrayList<String>> res, ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            res.add(drawBoard(cols));
            return;
        }
        // 要注意，是i < n，別搞錯了，debug好久
        // 類似排列組合的作法，不斷去試合法的i，若可以，則加入再繼續遞迴作。
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                helper(res, cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }
};
