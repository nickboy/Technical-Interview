public class Solution {
    public int addDigits(int num) {
        
        if (num < 10) {
            return num;
        }
        
        while (num >= 10) {
            int temp = num;
            int result = 0;
            while (temp > 0) {
                result += temp % 10;
                temp /= 10;
            }
            
            num = result;
        }
        
        return num;
    }

    public int addDigits2(int num) {
        
        if (num < 10) {
            return num;
        }
        
        return (num % 9 != 0) ? num % 9 : 9;
    }
}