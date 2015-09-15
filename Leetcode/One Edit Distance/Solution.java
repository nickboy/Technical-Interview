public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        // 把較短的字串排在前面
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        
        // 如果兩者長度差到2以上的話，代表兩者一定不是 One Edit Distance
        if (t.length() - s.length() > 1) {
            return false;
        }
        
        //用此變數來紀錄之前是否有不同過
        boolean diffBefore = false;
        
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                if (diffBefore) {
                    return false;
                }
                
                diffBefore = true;
                
                // 當不同時，且s較短，代表t字串可能多了一個字，但其他地方皆相同，
                // 因此不移動i指針繼續下面的比較。
                // 如ab, abc
                if (s.length() < t.length()) {
                    i--;
                }
            }
            
        }
        // 若走到這一步了且diffbefore為真，則有可能是 One Edit Distance
        // 若diffBefore為假，則需再作進一步的比較長度，以避免aa與aab的問題。
        return diffBefore || s.length() < t.length();
    }
}