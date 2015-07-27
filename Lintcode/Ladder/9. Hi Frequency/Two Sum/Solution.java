public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int curNum = numbers[i];
            if (map.containsKey(target - curNum)) {
                res[0] = map.get(target - curNum) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(curNum, i);
        }
        return res;
    }
}
