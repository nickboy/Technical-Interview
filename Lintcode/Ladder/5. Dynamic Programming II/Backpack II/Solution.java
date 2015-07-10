public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int len = A.length;
        int res[][] = new int[m+1][len+1];
        
        for (int i = 0; i <= m; i++) {
            res[i][0] = 0;
        }
        
        for (int i = 0; i <= len; i++) {
            res[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= len; j++) {
                if (i < A[j - 1]) {
                    res[i][j] = res[i][j - 1];
                } else {
                    int getItemJ = res[i - A[j - 1]][j - 1] + V[j - 1];
                    int notGetItemJ = res[i][j - 1];
                    res[i][j] = Math.max(getItemJ, notGetItemJ);
                }
            }
        }
        return res[m][len];
    }
}
