public class BetterSolution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        
        if (nums == null || nums.size() < k) {
            return 0;
        }
        
        int len = nums.size();
        
        // globalMax[i][j] 代表前j個元素切成i份子陣列的最大和
        int[][] globalMax = new int[k + 1][len + 1];
        for (int i = 1; i <= k; i++) {
            int localMax = Integer.MIN_VALUE;
            // 在此優化，j從i-1開始，因若元素個數小於切割數則無法切割
            // 取i-1到len-1是因為陣列範圍的關係，
            
            for (int j = i - 1; j < len; j++) {
                localMax = Math.max(localMax, globalMax[i - 1][j]) + nums.get(j);
                if (j == i - 1) {
                    globalMax[i][j + 1] = localMax; // 因無globalMax[i][j]可比較，故直接assign localmax
                } else {
                    globalMax[i][j + 1] = Math.max(globalMax[i][j], localMax);
                }
            }
        }
        
        return globalMax[k][len];
    }
}

