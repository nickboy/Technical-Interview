class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    // O(n) 解法，要算出總共有多少個5，因此要不斷的去除5^x，當5^x < n
    // 之前作時忽略了除以25, 125, 625...
    public long trailingZeros(long n) {
        long count = 0;
        for (int i = 5; i <= n; i = i * 5) {
            count += n / i;
        }
        return count;
    }

    // O(logN)的解法，不所遞迴去作
    public long trailingZerosRecursive(long n) {
        if (n < 4) {
            return 0;
        }
        return n/5 + trailingZeros(n/5);
    }
};
