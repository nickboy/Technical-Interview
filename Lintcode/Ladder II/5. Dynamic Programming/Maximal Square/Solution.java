public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int length = matrix.length;
        int width = matrix[0].length;
        int maxLength = 0;
        int[][] dp = new int[length][width];
        
        for (int i = 0; i < length; i++) {
            dp[i][0] = matrix[i][0];
            if (dp[i][0] == 1) {
                maxLength = 1;
            }
        }
        
        for (int i = 0; i < width; i++) {
            dp[0][i] = matrix[0][i];
            if (dp[0][i] == 1) {
                maxLength = 1;
            }
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxLength = (dp[i][j] > maxLength) ? dp[i][j] : maxLength;
                }
            }
        }
        
        
        
        return maxLength * maxLength;
    }
}
