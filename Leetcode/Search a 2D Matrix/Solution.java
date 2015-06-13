//Time : O(nlogm), m = number of rows, n = number of element in each list
//Space: O(1)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == target || matrix[i][cols -1] == target) {
                return true;
            }
            if (matrix[i][0] <= target || matrix[i][cols - 1] >= target) {
                boolean result = binarySearch(matrix[i], 0, cols - 1, target);
                if(result)
                    return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(int[] list, int start, int end, int target) {
        if (end < start)
            return false;
            
        int mid = (end + start) / 2;
        
        if(list[mid] == target) {
            return true;
        } else if (target > list[mid]) {
            return binarySearch(list, mid + 1, end, target);
        } else {
            return binarySearch(list,start,mid - 1, target);
        }
    }
}