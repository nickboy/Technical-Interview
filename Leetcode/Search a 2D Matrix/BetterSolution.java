//Time : O(m+n), m = number of rows, n = number of element in each list
//Space: O(1)
public class BetterSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        rows = 0;
        int cols = matrix[0].length -1;
        
        while (rows < matrix.length && cols >= 0) {
            if (matrix[rows][cols] == target) {
                return true;
            } else if (matrix[rows][cols] < target) {
                rows++;
            } else {
                cols--;
            }
        }
        return false;
    }
    
    
}