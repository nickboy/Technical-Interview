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
        ArrayList<Integer> cols = new ArrayList<Integer>();
        if (n == 0) {
            return res;
        }
    }
    
    private void helper(ArrayList<ArrayList<String>> res, ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            res.add(new ArrayList<String>(drawBoard(cols)));
            return;
        }
        for (int i = 0; i < cols.size(); i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            helper(res, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) == col) {
                return false;
            }
            
            if (Math.abs(cols.size() - i) == Math.abs(col - cols.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder tempString;
        for (int i = 0; i < cols.size(); i++) {
            tempString = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    tempString.append('Q');
                } else {
                    tempString.append('.');
                }
            }
            res.add(tempString.toString());
        }
        return res;
    }
};
