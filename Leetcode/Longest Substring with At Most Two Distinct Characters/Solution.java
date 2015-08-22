public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        
        for (int fast = 0, slow = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            
            while (slow < s.length() && map.size() > 2) {
                char candidate = s.charAt(slow);
                if (map.get(candidate) > 1) {
                    map.put(candidate, map.get(candidate) - 1);
                } else {
                    map.remove(candidate);
                }
                slow++;
            }
            
            if (map.size() <= 2) {
                maxLength = Math.max(maxLength, fast - slow + 1);
            }
        }
        
        return maxLength;
    }
 }