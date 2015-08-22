class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        
       if (prices == null || prices.length == 0) {
           return 0;
       }
       
       int len = prices.length;
       int[] left = new int[len];
       int[] right = new int[len];
       
       int profit = 0;
       int min = Integer.MAX_VALUE;
       
       for (int i = 0; i < len; i++) {
           profit = Math.max(profit, prices[i] - min);
           min = Math.min(min, prices[i]);
           left[i] = profit;
       }
       
       profit = 0;
       int max = prices[len - 1];
       for (int i = len - 1; i >= 0; i--) {
           profit = Math.max(profit, max - prices[i]);
           max = Math.max(max, prices[i]);
           right[i] = profit;
       }
       
       int maxProfit = 0;
       for (int i = 0; i < len - 1; i++) {
           maxProfit = Math.max(maxProfit, left[i] + right[i]);
       }
       
       return maxProfit;
    }
};
