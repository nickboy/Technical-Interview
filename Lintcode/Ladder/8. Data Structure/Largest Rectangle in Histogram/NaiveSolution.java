public class NaiveSolution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int result = 0;
        if (len == 0) {
            return result;
        }
        for (int start = 0; start < len; start++) {
            int length = height[start];
            for (int end = start; end < len; end++) {
                int width = end - start + 1;
                length = Math.min(length, height[end]);
                if (result <= width * length) {
                    result = width * length;
                }
            }
        }
        
        return result;
    }
}

