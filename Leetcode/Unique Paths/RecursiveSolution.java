public class RecursiveSolution {
    public int uniquePaths(int m, int n) {
        return helper(1, 1, m, n);
    }
    
    public int helper(int row, int column, int m, int n) {
        if (row == m && column == n) {
            return 1;
        }
        if (row > m || column > n) {
            return 0;
        }
        return helper(row + 1, column, m, n) + helper(row, column + 1, m, n);
    }
}