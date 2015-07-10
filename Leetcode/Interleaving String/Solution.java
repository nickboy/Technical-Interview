public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        int lenS3 = s3.length();
        
        if (lenS1 + lenS2 != lenS3) {
            return false;
        }
        
        boolean[][] res = new boolean[lenS1+1][lenS2+1];
        
        res[0][0] = true;
        for (int i = 1; i <= lenS1; i++) {
            res[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && res[i-1][0];
        }
        
        for (int i = 1; i <= lenS2; i++) {
            res[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && res[0][i-1];
        }
        
        for (int i = 1; i <= lenS1; i++) {
            for (int j = 1; j <= lenS2; j++) {
                res[i][j] = res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ||
                            res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        
        return res[lenS1][lenS2];
    }
}