public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //avoid duplicate solutions
            if (i == 0 || nums[i] > nums[i-1]) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if ( nums[l] + nums[r] + nums[i]== 0 ) {
                        
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        if (!res.contains(list)) {
                            res.add(list);
                        }
                        //move both pointers, since it is impossible get zero result 
                        //if it only move one pointer.
                        l++;
                        r--;
                        //avoid duplicate solutions
                        while ((l < r) && nums[l] == nums[l-1]) l++;
                        while ((l < r) && nums[r] == nums[r+1]) r--;
                    }else if (nums[l] + nums[r] + nums[i] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            
        }
        return res;
    }
}