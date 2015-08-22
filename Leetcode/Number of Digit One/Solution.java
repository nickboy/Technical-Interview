// 暴力法 會超時
public class Solution {
    public int countDigitOne(int n) {
        
        if (n == 0) {
            return 0;
        }
        
        long count = 0;
        for (long i = 1; i <= n; i++) {
            long num = i;
            
            while (num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
        }
        
        return (int) count;
    }
}