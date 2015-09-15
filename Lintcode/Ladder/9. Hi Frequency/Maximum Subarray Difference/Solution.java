public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
public int maxDiffSubArrays(ArrayList<Integer> nums) {
    
    if (nums == null || nums.size() == 0) {
        return 0;
    }
    
    int len = nums.size();
    int lLocalMax = nums.get(0);
    int lLocalMin = nums.get(0);
    int[] lGlobalMax = new int[len];
    int[] lGlobalMin = new int[len];
    lGlobalMax[0] = lLocalMax;
    lGlobalMin[0] = lLocalMin;
    
    for (int i = 1; i < len; i++) {
        lLocalMax = Math.max(nums.get(i), lLocalMax + nums.get(i));
        lGlobalMax[i] = Math.max(lGlobalMax[i - 1], lLocalMax);
        lLocalMin = Math.min(nums.get(i), lLocalMin + nums.get(i));
        lGlobalMin[i] = Math.min(lGlobalMin[i - 1], lLocalMin); 
    }
    
    int rLocalMax = nums.get(len - 1);
    int rLocalMin = nums.get(len - 1);
    int[] rGlobalMax = new int[len];
    int[] rGlobalMin = new int[len];
    rGlobalMax[len - 1] = rLocalMax;
    rGlobalMin[len - 1] = rLocalMin;
    
    for (int i = len - 2; i >= 0; i--) {
        rLocalMax = Math.max(nums.get(i), rLocalMax + nums.get(i));
        rGlobalMax[i] = Math.max(rGlobalMax[i+1], rLocalMax);
        rLocalMin = Math.min(nums.get(i), rLocalMin + nums.get(i));
        rGlobalMin[i] = Math.min(rGlobalMin[i+1], rLocalMin);
    }
    
    int res = 0;
    
    for (int i = 1; i < len - 1; i++) {
        if (res < Math.abs(lGlobalMin[i] - rGlobalMax[i+1])) {
            res = Math.abs(lGlobalMin[i] - rGlobalMax[i+1]);
        }
        if (res < Math.abs(lGlobalMax[i] - rGlobalMin[i+1])) {
            res = Math.abs(lGlobalMax[i] - rGlobalMin[i+1]);
        }
    }
    
    return res;

}
}


