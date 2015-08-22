public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        // deque 要用arraydeque來實作
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            // 把比目前這個數都小的其他數都從後面poll掉，
            // 因為那些數不可能再成為maximum的其中一員
            while(!deque.isEmpty() && nums[i] >deque.peekLast()) {
                deque.pollLast();
            }
            
            // 把目前最大的poll進來，此時deque可能還有數，但一定比目前這個數大
            deque.offer(nums[i]);
            
            // 確保超出window範圍的數已被刪除
            if (i > k - 1) {
                if (deque.peekFirst() == nums[i - k]) {
                    deque.pollFirst();
                }
            }
            
            // 此時可以放心把deque的最前面那個peek出來放到答案中
            if (i >= k - 1) {
                res.add(deque.peekFirst());
            }
        }
        
        return res;
    }
}

