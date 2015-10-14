public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] idx = new int[]{0, 1, 0, -1};
        int[] idy = new int[]{1, 0,-1, 0};
        int direction = 0;
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = 0;
            int newX = x + idx[direction];
            int newY = y + idy[direction];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || matrix[newX][newY] == 0) {
                direction = (direction + 1) % 4;
                newX = x + idx[direction];
                newY = y + idy[direction];
            }
            
            x = newX;
            y = newY;
        }
        
        return res;
    }
}