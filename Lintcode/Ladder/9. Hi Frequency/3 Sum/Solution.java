public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //若要用雙指針來作的話且避免取到重複的，一定要排序陣列
        Arrays.sort(numbers);
        // 解法，固定第i個數，i後面的數用雙指針來一一比對。
        // 到numbers.length - 2因為一定要三個數，最後兩個數留在裡面作處理
        for (int i = 0; i < numbers.length - 2; i++) {
            // 避免重複取一樣的
            if (i != 0 && numbers[i-1] == numbers[i]) {
                continue;
            }
            //用雙指針來作，
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int temp = numbers[i] + numbers[left] + numbers[right];
                if (temp == 0) {
                    //有找到符合的三個數，創新的list把結果加到res中
                    ArrayList<Integer> tempRes = new ArrayList<Integer>();
                    tempRes.add(numbers[i]);
                    tempRes.add(numbers[left]);
                    tempRes.add(numbers[right]);
                    res.add(tempRes);
                    left++;
                    right--;
                    // 防止取到重複的後面兩個數，只要遇到相鄰兩數相同，則移動指針
                    // 要注意比對時pointer不要超出，left是往前比，right是往後比
                    while (left < right && numbers[left - 1] == numbers[left]) {
                    left++;
                    }
                    while (left < right && numbers[right] == numbers[right+1]) {
                        right--;
                    }
                } else if (temp < 0) {
                    left++;
                } else {
                    right--;
                }
                
            }
        }
        return res;
    }
}
