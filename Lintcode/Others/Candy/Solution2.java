public class Solution2 {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        
        if (ratings == null || ratings.length <= 1) {
            return 1;
        }
        
        int minCount = 0;
        int len = ratings.length;
        int[] count = new int[ratings.length];
        count[0] = count[len - 1] = 1; // 記得作初始化
        
        // 往右掃，不斷的與前面比，若rating 較大則比前面的糖果數再多一
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = Math.max(count[i], count[i - 1] + 1);
            } else {
                count[i] = 1; // 因至少要一顆糖
            }
        }
        
        // 往左掃，不斷的與後面比，若rating 較大則比後面的糖果數再多一
        // 記得與目前的糖果數比較哪個較多
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }
        
        // 掃一次把所有糖果數加起來
        for (int i = 0; i < len; i++) {
            minCount += count[i];
        }
        
        return minCount;
    }
}
