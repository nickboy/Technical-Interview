class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int num;
    int result;
    public int totalNQueens(int n) {
        num = n;
        //write your code here
        if (n == 0) {
            return 0;
        }
        helper(new ArrayList<Integer>());
        return result;
        
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++) {
            //確認是否在同一行
            if (cols.get(i) == col) {
                return false;
            }
            //確認左上到右下  (x1-y1) == (x2-y2)
            if (i - cols.get(i) == row - col) {
                return false;
            }
            //確認右上到左下 (x1+y1) == (x2+y2)
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    
    //用類似排列組合的方式遞迴去作
    private void helper(ArrayList<Integer> cols) {
        if (cols.size() == num) {
            result++;
        }
        
        for (int i= 0; i < num; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                helper(cols);
                cols.remove(cols.size() - 1);
            }
        }
    }
};


