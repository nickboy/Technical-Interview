public class Solution {
    public int hIndex(int[] citations) {
        
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;
    }
}