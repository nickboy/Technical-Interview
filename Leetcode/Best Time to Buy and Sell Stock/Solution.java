public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int maxDiff = prices[1] - prices[0];
        int minValue = prices [0];
        for(int i = 1; i < prices.length; i++) {
            //if found the difference greater than maxDiff
            //update it.
            if(prices[i] - minValue > maxDiff) {
                maxDiff = prices[i] - minValue;
            }
            //if found the smaller minValue
            //update it
            if(prices[i] < minValue) {
                minValue = prices[i];
            }
        }
        //check negative result
        if (maxDiff < 0) {
            return 0;
        }
        
        return maxDiff;
    }
}