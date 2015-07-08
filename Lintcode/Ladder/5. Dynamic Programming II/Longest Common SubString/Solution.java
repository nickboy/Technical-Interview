public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] res = new int[m + 1][n + 1];
        int max = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                    if (res[i][j] > max) {
                        max = res[i][j];
                    } 
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return max;
    }
}
