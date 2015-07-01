public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> tempRes = new ArrayList<String>();
        int len = s.length();
        
        if (len == 0) {
            return res;
        }
        
        helper(s, res, tempRes, 0);
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //使用類似排列組合的方法來找出所有可能性，不斷的加長substring
    private void helper(String s, List<List<String>> res, ArrayList<String> tempRes, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(tempRes));
            return;
        }
        
        //由pos加1是為了要切字串來驗證是否為palindrome
        //若由pos開始則只有一個char，沒啥好驗的
        //i <= s.length() 考慮到了substring的特性
        //System.out.println("abc");
        //String cde = "cde";
        //System.out.println("abc" + cde);
        //String c = "abc".substring(2,3);
        //String d = cde.substring(1, 2);

        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos,i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            tempRes.add(prefix);
            helper(s, res, tempRes, i);
            tempRes.remove(tempRes.size() - 1);
        }
    }
}