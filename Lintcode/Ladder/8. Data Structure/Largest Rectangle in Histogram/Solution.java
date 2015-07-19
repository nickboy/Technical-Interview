public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // 以每一個點為中心，找出左右第一位比該點小的值
        // 使用 stack來輔助，若stack不為升序的話，則不斷pop，每一次pop即可得到兩個紀錄
        // 使得最上面那個點被彈出的值為被彈出的點之右邊第一個小的值。
        // 被pop那個點的下一個，則否左邊第一個比該點小的值
        // stack塞的數為index
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            // 記得while是把stack中第一個值當index來抓出height來比
            while (!stack.isEmpty() && cur < height[stack.peek()]) {
                // 直接用pop出來的index來取出高
                // 如果stack為empty，則代表該點右邊沒有最小的，即走到頭，所以設為i
                // 若不為empty，則把彈出後的stack取最上面的值去減i來得到寬
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}

