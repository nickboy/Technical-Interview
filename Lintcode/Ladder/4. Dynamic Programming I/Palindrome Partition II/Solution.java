public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        //初始化，極端的情況下就是每隔一個char就切一刀
        //設為lenght+1，是因為要紀錄前i個char最小需要切幾刀
        //預設f[0] = -1
        int[] res = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            res[i] = i - 1;
        }
        
        //主程式
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s, j , i - 1)) {
                    res[i] = Math.min(res[i], res[j] + 1);
                }
            }
        }
        return res[s.length()];
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
