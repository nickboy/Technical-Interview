public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // sum[i...j] = sum[0...j] - sum[0...i-1]
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum)+1); //因該值算的是 [0...i-1]的總合，因此index要加1
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }
}
