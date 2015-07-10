public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // f[i][j] 表示S前i個char中選T的前j個char，有多少方案
        
        int m = S.length();
        int n = T.length();
        int[][] res = new int[m+1][n+1];
        
        //初始化，S中前i個char中選0個，方案只可能有一種
        for (int i = 0; i <= m; i++) {
            res[i][0] = 1;
        }
        
        //初始化，因S沒可選，沒有任何方案
        for (int i = 0; i <= n; i++) {
            res[0][i] = 0;
        }
        
        //特別處理res[0][0]
        res[0][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    //若S的第i個char與T的第j個char相同，則第i個char可選可不選
                    //res[i-1][j-1]代表選了第i個，
                    //res[i-1][j]代表不選第i個，所以前i-1個char已選了j個
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                } else {
                    //因不同，則S第i個char必不能選
                    res[i][j] = res[i-1][j];
                }
            }
        }
        
        return res[m][n];
    }
}
