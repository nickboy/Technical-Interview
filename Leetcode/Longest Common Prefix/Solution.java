public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int shortestLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestLength) {
                shortestLength = strs[i].length();
            }
        }
        
        String res = "";
        for (int i = 0; i < shortestLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return res;
                }
            }
            
            res = strs[0].substring(0, i + 1);
        }
        
        return res;
    }
}