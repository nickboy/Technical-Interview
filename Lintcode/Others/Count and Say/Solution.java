public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        
        String prev = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j - 1) == prev.charAt(j)) {
                    count++;
                } else {
                    cur.append(count).append(prev.charAt(j - 1));
                    count = 1;
                }
            }
            
            // 為了處理最後一位，加上若 prev的長度只有一位的話。
            cur.append(count).append(prev.charAt(prev.length() - 1));
            prev = cur.toString();
        }
        
        return prev;
    }
}
