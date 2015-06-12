//Time : O(2n)
//Space : O(1)
public class NaiveSolution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0)
            return;
        // 1,2  to 1,3
        // 3,4     2,4
        // do transpose    
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }
        //reverse matrix base on horizontal line
        for(int i = 0; i < len/2; i++) {
            for (int j = 0; j < len; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-i-1][j];
                matrix[len-i-1][j] = temp;
            }
        }
        
    }
}