public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int res = 0;
        
        for (int i = len - 1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            }
            //if res == 0 which means the counting procecedure is not start yet.
            if (s.charAt(i) == ' ' && res != 0) {
                return res;
            }
        }
        return res;
    }
}