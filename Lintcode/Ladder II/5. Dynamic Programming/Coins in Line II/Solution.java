public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
     
    int[] dp;
    int len;
    public boolean firstWillWin(int[] values) {
        
        if (values == null || values.length == 0) {
            return false;
        }
        
        len = values.length;
        dp = new int[len + 1];
        Arrays.fill(dp, -1);
        
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += values[i];
        }
        
        int res = memorySearch(len, values);
        
        if (res > sum / 2) {
            return true;
        } else {
            return false;
        }
    }
    
    private int memorySearch(int n, int[] values) {

        if (dp[n] != -1) {
            return dp[n];
        } else if (n == 0) {
            dp[n] = 0; // 沒硬幣可拿，獲利0
        } else if (n == 1) {
            dp[n] = values[len - 1]; // 剩下一個硬幣，拿最後那個
        } else if (n == 2) {
            dp[n] = values[len - 2] + values[len - 1]; // 剩下兩個硬幣，拿最後兩個
        } else if (n == 3) {
            dp[n] = values[len - 2] + values[len - 3]; // 剩下三個硬幣，拿兩個，最後一個留給後手
        } else {
            // 找出先手拿一個硬幣的最大獲利
            int firstTakeOne = Math.min(memorySearch(n-2, values), memorySearch(n-3, values)) 
                                + values[len - n];
            // 找出先手拿二個硬幣的最大獲利，記得第二個硬幣是len - n + 1
            int firstTakeTwo = Math.min(memorySearch(n-3, values), memorySearch(n-4, values)) 
                                + values[len - n] + values[len - n + 1];
            dp[n] = Math.max (firstTakeOne, firstTakeTwo);
                    
        }
        return dp[n];
    }
}
