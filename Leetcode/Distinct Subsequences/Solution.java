public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[][] res = new int[m+1][n+1];
        
        // res[i][j] 表示res前s的前i個char取出來可以對上t的前j個char的最大distinct數
        
        res[0][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            res[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            res[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                } else {
                    //不取當下i
                    res[i][j] = res[i-1][j];
                }
            }
        }
        
        return res[m][n];
    }
}