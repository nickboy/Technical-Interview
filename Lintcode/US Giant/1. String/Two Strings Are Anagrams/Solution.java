public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    // 用hashmap作，但space要O(n)
    public boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 0);
            }
            map.put(cur, map.get(cur) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if (!map.containsKey(cur)) {
                return false;
            }
            map.put(cur, map.get(cur) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
     }
};
