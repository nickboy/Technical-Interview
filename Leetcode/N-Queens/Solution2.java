public class Solution {
    int num;
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        
        if (n == 0) {
            return res;
        }
        
        int[] colIndex = new int[n];
        num = n;
        helper(res, colIndex, 0);
        return res;
    }
    
    private void helper(List<String[]> res, int[] colIndex, int row) {
        if (row == num) {
            res.add(printBoard(colIndex));
            return;
        }
        
        for (int i = 0; i < num; i++) {
            colIndex[row] = i;
            if (isValid(colIndex, row)) {
                helper(res, colIndex, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] colIndex, int row) {
        for (int i = 0; i < row; i++) {
            if (colIndex[i] == colIndex[row] || Math.abs(colIndex[i] - colIndex[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
    
    private String[] printBoard(int[] colIndex) {
        String[] result = new String[num];
        for (int row = 0; row < num; row++) {
            char[] chars = new char[num];
            Arrays.fill(chars,'.');
            for (int col = 0; col < num; col++) {
                if (col == colIndex[row]) {
                    chars[col] = 'Q';
                }
            }
            result[row] = new String(chars);
        }
        return result;
    }
}