public class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markDFS(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        
        return count;
    }
    
    private void markDFS(char[][] grid, int row, int col, int rows, int cols) {
        
        int[][] directions = new int[][] {{-1,0}, {1,0}, {0, -1}, {0, 1}};
        grid[row][col] = '0';
        
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (grid[newRow][newCol] == '1') {
                    markDFS(grid, newRow, newCol, rows, cols);
                }
            }
        }
    }
}