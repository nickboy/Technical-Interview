public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int length = 0;
        int[] map = new int[256];
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] += 1;
                j++;
            }
            
            length = Math.max(length, j - i);
            
            map[s.charAt(i)] -= 1;
        }
        
        return length;
    }
}
