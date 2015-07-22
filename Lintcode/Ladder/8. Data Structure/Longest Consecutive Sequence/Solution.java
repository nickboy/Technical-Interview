public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */

    // Sort & search: space O(1), time O(n logn)
    // HashMap: space O(n), time O(n)
    public int longestConsecutive(int[] num) {
        // write you code here
        int len = num.length;
        if (num == null || num.length == 0) {
            return 0;
        }
        //先把所有array的值全塞進hashmap裡，0代表尚末拜訪過。
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(num[i], 0);
        }
        
        int max = 1;
        for (int number : num) {
            //為了不重複計算，只要拜訪過(值為1)即跳下一個number
            if (map.get(number) == 1) {
                continue;
            }
            //把陣列中每一個數拿出來不斷去往前往後比
            //有找到連續的值就不斷加一
            int curMax = 1;
            int i = number;
            while (map.containsKey(i+1)) {
                map.put(i+1, 1);
                i++;
                curMax++;
            }
            //重設i，接著繼續往前找
            i = number;
            while (map.containsKey(i-1)) {
                map.put(i-1, 1);
                i--;
                curMax++;
            }
            
            max = (curMax > max) ? curMax : max;
        }
        return max;
    }
}
