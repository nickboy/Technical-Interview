public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        
        int currentNumber = -1;
        int numberCount = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (currentNumber != nums.get(i)) {
                numberCount--;
                if (numberCount == 0) {
                    currentNumber = nums.get(i);
                    numberCount++;
                }
                
            } else {
                numberCount++;
            }
        }
        
        return currentNumber;
    }
}