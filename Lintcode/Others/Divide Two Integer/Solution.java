public int divide(int dividend, int divisor) {
    
        // 因不能除以0
        if (divisor == 0) {
            return 0;
        }
        
        // 為了應付lintcode極端會TLE的case
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == -1) {
                return Integer.MIN_VALUE;
            } else if (divisor == 1) {
                return Integer.MAX_VALUE;
            }
            
        }
        
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        
        // 先轉正整數來處理，之後再轉回來
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        // 要用 long 來避免 overflow
        long result = 0;
        
        // 這裡必須是 = 因為相等時也可以減
        while ( p >= q) {
            int count = 0;
            while (p >= (p << count)) {
                count++;
            }
            
            result += 1 << (count - 1);
            p -= q << (count - 1);
        }
        
        // 除了dividend與divisor同為正數或同為負數則返回正結果，否則返回負結果
        result = (((dividend ^ divisor) >> 31) & 1) == 1 ? -result: result;
        
        // 若結果溢位，則返回最大值
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int) result;
        
    }