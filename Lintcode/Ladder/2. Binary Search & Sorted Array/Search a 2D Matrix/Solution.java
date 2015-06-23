public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix.length == 0) {
            return false;
        }
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int midValue = matrix[mid / cols][mid % cols];
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                end = mid;
            } else if (midValue < target) {
                start = mid;
            }
        }
        int startValue = matrix[start / cols][start % cols];
        int endValue = matrix[end / cols][end % cols];
        if (startValue == target || endValue == target) {
            return true;
        } else {
            return false;
        }
    }
}

