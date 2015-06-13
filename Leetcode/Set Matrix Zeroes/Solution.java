public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] isZeroRow = new boolean[rows];
        boolean[] isZeroCol = new boolean[cols];
        
        //determine which col and row need to set to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    isZeroRow[i] = true;
                    isZeroCol[j] = true;
                }
            }
        }
        
        //modify origin matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isZeroRow[i] || isZeroCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}