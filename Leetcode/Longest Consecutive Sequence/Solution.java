public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (map.get(curNum) == 1) {
                continue;
            }
            int locMax = 1;
            while (map.containsKey(curNum+1)) {
                locMax += 1;
                curNum += 1;
                map.put(curNum, 1);
            }
            
            curNum = nums[i];
            while (map.containsKey(curNum-1)) {
                locMax += 1;
                curNum -= 1;
                map.put(curNum,1);
            }
            max = (max < locMax) ? locMax : max;
            
        }
        return max;
        
    }
}