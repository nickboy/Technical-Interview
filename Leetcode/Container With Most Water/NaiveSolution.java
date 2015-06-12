public class NaiveSolution {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length == 0)
            return 0;
        
        int maxSize = 0;
        for (int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                maxSize = Math.max(maxSize, (j-i) * Math.min(height[i],height[j]));
            }
        }
        return maxSize;
    }
}