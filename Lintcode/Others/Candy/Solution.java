public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int minCount = 0;
        int[] count = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            
            int curCount = 1;
            if ((i - 1) >= 0 && ratings[i] > ratings[i - 1]) {
                curCount = Math.max(curCount, ratings[i - 1] + 1);
            }
            if ((i + 1) < ratings.length && ratings[i] > ratings[i + 1]) {
                curCount = Math.max(curCount, ratings[i + 1] + 1);
            }
            count[i] = curCount;
            minCount += curCount;
        }
        
        return minCount;
    }
}
