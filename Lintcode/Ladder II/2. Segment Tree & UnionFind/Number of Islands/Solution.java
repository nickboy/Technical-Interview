public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    public int numIslands(boolean[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == true) {
                    count++;
                    dfsMark(grid, i, j, m, n);
                }
            }
        }
        
        return count;
        
    }
    
    private void dfsMark(boolean[][] grid, int row, int col, int rows, int cols) {
        int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        
        grid[row][col] = false;
        
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (grid[newRow][newCol] == true) {
                    dfsMark(grid, newRow, newCol, rows, cols);
                } 
            }
        }
    }
}
