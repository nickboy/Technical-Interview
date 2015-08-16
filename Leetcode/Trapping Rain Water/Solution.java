public class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int len = height.length;
        int max = height[0];
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        
        for (int i = 1; i < len; i++) {
            if (max < height[i]) {
                max = height[i];
            } 
            leftMax[i] = max;
        }
        
        max = height[len - 1];
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        
        for (int i = len - 2; i >= 0; i--) {
            if (max < height[i]) {
                max = height[i];
            }
            rightMax[i] = max;
        }
        
        int volume = 0;
        for (int i = 1; i < len - 1; i++) {
            int current = Math.min(rightMax[i], leftMax[i]) - height[i];
            if (current > 0) {
                volume += current;
            }
        }
        
        return volume;
    }
}