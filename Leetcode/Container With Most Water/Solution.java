//Time complexity : O(n)

public class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length == 0)
            return 0;
        
        int maxSize = 0;
        int start = 0;
        int end = length - 1;
        while(start < end) {
            int currentSize = (end-start) * Math.min(height[start], height[end]);
            maxSize = Math.max(maxSize, currentSize);
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxSize;
    }
}