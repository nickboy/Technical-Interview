public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        
        int[][] res = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) != B.charAt(j-1)) {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                } else {
                    res[i][j] = res[i-1][j-1] + 1;
                }
            }
        }
        
        return res[m][n];
    }
}

