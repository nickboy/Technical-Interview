public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxDiff = prices[1] - prices[0];
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minValue > maxDiff) {
                maxDiff = prices[i] - minValue;
            }
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
        }
        if (maxDiff < 0) {
            return 0;
        } else {
            return maxDiff;
        }
        
    }
}
