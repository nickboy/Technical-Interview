public class Solution {
    boolean[][] isPalindrome;
    public int minCut(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }
        
        int[] res = new int[len + 1];
        isPalindrome = new boolean[len][len];
        getIsPalindrome(s, isPalindrome);
        for (int i = 0; i <= len; i++) {
            res[i] = i - 1;
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // 檢查後面j+1 到i 之間是否為palindrome
                // 若是，再檢查目前最小cut再加1刀是否有更小，若有，則更新目前res值
                if (isPalindrome[j][i - 1]) {
                    res[i] = res[i] < res[j] + 1 ? res[i] : res[j] + 1;
                }
                
            }
        }
        return res[len];
        
    }
    //預先用dp處理ispalindrome陣列來節省時間
    private void getIsPalindrome(String s, boolean[][] isPalindrome) {
        //自己一個char一定是palindrome
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        //處理目前與下一個是否為palindrome
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        
        //處理剩下的，此為區間型的dp，先列舉長度再列舉起始點
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; length + start < s.length(); start++) {
                isPalindrome[start][start + length] = 
                    isPalindrome[start + 1][start + length - 1] && 
                    s.charAt(start) == s.charAt(start+length);
            }
        }
    }
}