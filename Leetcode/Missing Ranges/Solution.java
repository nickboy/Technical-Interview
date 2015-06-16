//lower = 5, upper = 10
//nums = 7,
//res ["5-6", "8-10"];

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int len = nums.length;
        
        //start from lower - 1
        int previous = lower - 1;
        for (int i = 0 ; i <= len; i++) {
            //take care of boundary condition
            int cur = (i == len) ? upper + 1 : nums[i];
            
            if (cur - previous > 1) {
                res.add(getRange(previous + 1, cur - 1));
            }
            previous = cur;
        }
        return res;
    }
    
    //generate range string
    private String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
}