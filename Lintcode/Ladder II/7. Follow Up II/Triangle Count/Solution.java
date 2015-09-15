public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        
        if (S == null || S.length <= 2) {
            return 0;
        }
        
        Arrays.sort(S);
        int count = 0; 
        int len = S.length;
        
        for (int i = 0; i < len; i++) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (S[start] + S[end] > S[i]) {
                    count += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return count;
    }
}

