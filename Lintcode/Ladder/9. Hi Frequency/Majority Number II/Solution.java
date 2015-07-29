public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        // 分別使用四個變數，來紀錄當前的兩個候選人是誰以及當下的count為多少
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2--;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // 再go through一次來確認
        count1 = 0; 
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        
        return count1 > count2 ? candidate1 : candidate2;
    }
}

