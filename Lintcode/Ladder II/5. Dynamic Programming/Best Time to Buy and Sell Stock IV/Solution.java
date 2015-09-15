class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        //由於若k超大的話，則退化為 Best Time to Buy and Sell Stock II，
        if ( k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i - 1] < prices[i]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        // globalMax[i][j] 表示在前i天作了j次的最大總獲利為多少，因k包含了第0次，
        // 所以初始化為k+1
        // localMax[i][j] 表示第i天一定要作了第j次交易的最大獲利為多少。
        int len = prices.length;
        int[][] globalMax = new int[len][k+1];
        int[][] localMax = new int[len][k+1];
        int profit = 0;
        
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                // localMax[i - 1][j] + diff 表示把原本在第i-1應該要賣掉的股票延到第i天賣。
                // localMax[i - 1][j - 1] + diff 表示在第i-1天時賣了之後馬上又買，接著在第i天賣掉。
                localMax[i][j] = Math.max(localMax[i-1][j] + diff, globalMax[i-1][j-1] + diff);
                globalMax[i][j] = Math.max(localMax[i][j], globalMax[i-1][j]);
            }    
        }
        return globalMax[len-1][k];
    }
}