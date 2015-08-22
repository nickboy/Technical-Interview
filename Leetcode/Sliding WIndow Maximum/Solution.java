public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < len; i++) {
            
            int now = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < now) {
                deque.pollLast();
            }
            
            deque.offer(now);
            
            if (i > k - 1) {
                if (deque.peekFirst() == nums[i - k]) {
                    deque.pollFirst();
                }
            }
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst(); 
            }
        }
        
        return res;
    }
}