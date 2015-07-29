public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0 || k == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else if (map.size() < k)  {
                map.put(cur, 1);
            } else if (map.size() >= k){
                removeKey(map);
            }
        }
        // 把每個元素的count設為0再重新算，類似majority number 1 and 2
        for (int key : map.keySet()) {
            map.put(key, 0);
        }
        //重算一次正確的count，因第一個for loop可能會把count抵消
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            }
        }
        //再來過一遍map中的每個元素，如果count超過 n/k 則輸出
        for (int key : map.keySet()) {
            if (map.get(key) > nums.size() / k) {
                return key;
            }
        }
        return 0;
    }
    
    private void removeKey(Map<Integer, Integer> map) {
        // 不能直接get邊remove，會有concurrent的問題，因此先把要remove的存到一個list
        // 接著再用一次for來remove map中的元素
        Set<Integer> keySet = map.keySet();
        List<Integer> removeList = new ArrayList<Integer>();
        for (Integer i : keySet) {
            if (map.get(i) == 1) {
                removeList.add(i);
            } else {
                map.put(i, map.get(i) - 1);
            }
        }
        for (Integer i : removeList) {
            map.remove(i);
        }
    }
}

