public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        
        int[][] res = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            res[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            res[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    //res[i-1][j]，把第一個string的第i個char刪掉，
                    //res[i][j-1]，把加入char到第一個string的第i個位置來match第二個string的第j個char
                    // 因此要確保前i個位置與前j-1個位置值一樣
                    //res[i-1][j-1]，直接replace，因此確保兩個string的前面char都一樣
                    res[i][j] = Math.min(res[i-1][j], Math.min(res[i][j-1], res[i-1][j-1])) + 1;
                } else {
                    //因為都一樣，因此只要確保add跟delete後的成本比什麼都不變來得低
                    res[i][j] = Math.min(res[i-1][j-1], Math.min(res[i][j-1] + 1, res[i-1][j-1] + 1));
                }
            }
        }
        return res[m][n];
    }
}
