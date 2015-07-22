public class Solution {
    public boolean isPowerOfTwo(int n) {
        //記得處理0與負數
        if (n <= 0) {
            return false;
        }
        
        int result = n & (n-1);
        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }
}