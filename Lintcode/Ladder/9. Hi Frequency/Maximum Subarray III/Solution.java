public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
public int maxSubArray(ArrayList<Integer> nums, int k) {
    
    if (nums.size() < k )
        return 0;
        
    int len = nums.size();
    
    int[][] dp = new int[len + 1][k + 1];
    
    for (int i = 1; i <= len; i++) {
        for (int j = 1; j <= k; j++) {
            
            // 代表陣列前i個數太少，不夠切成j個子陣列，因此最大值為0。
            if (i < j) {
                dp[i][j] = 0;
                continue;
            }

            // 以下這段程式碼，主要是枚舉從j-1到i-1之間的最大subarray，
            // dp[i][j] 代表的是陣列中前i個元素切成j個子陣列的最大和為多少
            // 下面作法其實跟Maximum Subarray I一樣
            dp[i][j] = Integer.MIN_VALUE;
            for (int p = j - 1; p <= i - 1; p++) {
                int localMax = nums.get(p);
                int globalMax = localMax;

                for (int t = p + 1; t <= i - 1; t++) {
                    localMax = Math.max(localMax + nums.get(t), nums.get(t));
                    globalMax = Math.max(localMax, globalMax);
                }
                
                if (dp[i][j] < dp[p][j - 1] + globalMax) {
                    dp[i][j] = dp[p][j - 1] + globalMax;
                }
            }
        }
    }
    
    return dp[len][k];
}
}

