public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        // 解法類似3sum，只是需要用兩個變數來判斷最接近的值，
        // 固定一點i，接著後面的數組用雙指針來一一比對
        int minDistance = Integer.MAX_VALUE;
        int closet = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            int tempSum;
            int left = i+1;
            int right = numbers.length - 1;
            while (left < right) {
                tempSum = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(tempSum - target) < minDistance) {
                    minDistance = Math.abs(tempSum - target);
                    closet = tempSum;
                }
                if (tempSum < target) {
                    left++;
                } else if (tempSum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return closet;
    }
}

