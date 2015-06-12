public class NaiveSolution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (rows == 0 && cols == 0)
            return 0;
        int[][] res = new int[rows][cols];
        res[0][0] = grid[0][0];
        //deal with first row
        for (int i = 1; i < cols; i++) {
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        //deal with first column
        for (int i = 1; i < rows; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        //start the dynamic programming process
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }
        return res[rows - 1][cols - 1];
        
    }
}