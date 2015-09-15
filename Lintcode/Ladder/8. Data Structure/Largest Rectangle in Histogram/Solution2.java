public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int len = height.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= len; i++) {
            int cur;
            if (i == len) {
                cur = -1;
            } else {
                cur = height[i];
            }
            
            if (stack.isEmpty() || height[stack.peek()] < cur) {
                stack.push(i);
            } else {
                int curIdx;
                int h;
                int w;
                int area;
                
                while (!stack.isEmpty() && height[stack.peek()] > cur) {
                    curIdx = stack.pop();
                    h = height[curIdx];
                    
                    if (stack.isEmpty()) {
                        w = i;
                    } else {
                        w = i - stack.peek() - 1;
                    }
                    
                    area = h * w;
                    maxArea = (maxArea > area) ? maxArea : area;
                }
                
                stack.push(i);
            }
            
        }
        
        return maxArea;
    }
}

