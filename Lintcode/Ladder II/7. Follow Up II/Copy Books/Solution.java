public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        
        int len = pages.length;
        k = Math.min(k, len); //若k多於書本書，多出來的那些人不需要
        
        int[] sumFromStart = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += pages[i];
            sumFromStart[i] = sum;
        }
        
        // mins[i][j] ：代表前i個人抄第j本書的最少時間為多少。
        int[][] mins = new int[k + 1][len];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < len; j++) {
                mins[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 1 || j == 0) { 
                    // 如果只有一位writer，則讓他抄前j本書，
                    // 如果只有一本書，則讓一位writer抄那本書
                    mins[i][j] = sumFromStart[j];
                } else {
                    for (int t = j - 1; t >= 0; t--) {
                        // 在此枚舉從j-1到0本的最小抄書時間，
                        // 代表前i-1個人抄前t本書，最後那個人抄從j+1到t本書，
                        // 取max是因為若其中一群人抄完了，而另一個人還沒抄完，則等他的時間也要算進去
                        // 反之亦然
                        int cur = Math.max(mins[i-1][t], sumFromStart[j] - sumFromStart[t]);
                        mins[i][j] = Math.min(cur, mins[i][j]);
                    }
                }
            }
        }
        
        return mins[k][len - 1];
    }
}
