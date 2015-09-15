public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = heights.length - 1;
        while (heights[left] == 0) {
            left++;
        }
        
        while(heights[right] == 0) {
            right--;
        }
        
        int capacity = Math.min(heights[left], heights[right]) * (right - left);
        while (left < right) {
            int curCapacity = 0;
            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
            curCapacity = Math.min(heights[left], heights[right]) * (right - left);
            capacity = curCapacity > capacity ? curCapacity : capacity;
        }
        
        return capacity;
    }
}
