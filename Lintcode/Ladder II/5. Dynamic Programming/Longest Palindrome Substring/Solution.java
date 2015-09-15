public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        int maxLength = 0;
        
        // j枚舉終點，i枚舉超始點
        // subString(i,j)表示從string的index i取到j-1，即不包含j本身。
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ( j - i < 2 || dp[i+1][j-1]);
                
                if (dp[i][j]) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        return res;
    }
}
