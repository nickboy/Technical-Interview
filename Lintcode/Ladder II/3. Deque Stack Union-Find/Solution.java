public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        // 使用一個left陣列，來紀錄當前柱子左邊最高的柱子高度
        int[] left = new int[heights.length];
        int max = heights[0];
        left[0] = heights[0];
        
        // 從左往右掃一遍，對於每個heights[i]，找出他左邊最大的高度並存入left[i]
        for (int i = 1; i < heights.length; i++) {
            if (max < heights[i]) {
                max = heights[i];
                left[i] = max;
            } else {
                left[i] = max;
            }
        }
        
        // 使用一個right陣列，來紀錄當前柱子右邊最高的柱子高度
        int[] right = new int[heights.length];
        max = heights[heights.length - 1];
        right[heights.length - 1] = heights[heights.length - 1];
        
        // 從右往左掃一遍，對於每個heights[i]，找出他右邊最大的高度並存入right[i]
        for(int i = heights.length - 2; i >= 0; i--) {
            if (max < heights[i]) {
                max = heights[i];
                right[i] = max;
            } else {
                right[i] = max;
            }
        }
        
        // 計算總容積，從1到 到數第二個，因第一個柱子與最後一個柱子一定沒辦法灌水
        int volume = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            // 找出該柱子的左右兩邊較小的柱子，並減掉當前柱子的容積，
            // 便為目前柱子能灌多少水，若當前容積比0大代表可灌水，則加入volume。
            int curVolume = Math.min(right[i], left[i]) - heights[i];
            if (curVolume > 0) {
                volume += curVolume;
            }
        }
        
        return volume;
    }
}
