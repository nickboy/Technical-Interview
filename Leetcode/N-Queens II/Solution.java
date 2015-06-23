public class Solution {
    int sum = 0;
    int num;
    public int totalNQueens(int n) {
        if (n == 0) {
            return sum;
        }
        
        int[] colIndex = new int[n];
        num = n;
        helper(colIndex, 0);
        return sum;
    }
    
    private void helper(int[] colIndex, int row) {
        if (row == num) {
            sum += 1;
            return;
        }
        for (int i = 0; i < num; i++) {
            colIndex[row] = i;
            if (isValid(colIndex, row) {
                helper (colIndex, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] colIndex, int row) {
        for (int i = 0; i < num; i++) {
            if (colIndex[row] == colIndex[i]) || (Math.abs(colIndex[row] - colIndex[i]) == row - i)) {
                return false;
            }
        }
        return true;
    }
}