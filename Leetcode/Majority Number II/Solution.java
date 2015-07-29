public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        //先歷遍陣列中所有元素
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // 因count之前可能有被抵消掉，因此要重算一次
        count1 = count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }
        // 因為在這裡是需要所有超過 n/3的元素，
        // 因為要超過n/3 所以最多只有兩個candidate
        // 重算完count後，要確認count有超過三分之一
        if (count1 > nums.length /3) {
            res.add(candidate1);
        } 
        if (count2 > nums.length /3) {
            res.add(candidate2);
        }
        return res;
    }
}