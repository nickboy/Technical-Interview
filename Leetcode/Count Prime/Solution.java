public class Solution {
    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
            
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        double sqrtNum = Math.sqrt(n);
        
        for(int i = 2; i < sqrtNum; i++ ) {
            if(isPrime[i]) {
                for(int j = i*i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
            
        }
        
        int count = 0;
        for(int i = 2; i < n; i++) {
            count += isPrime[i] ? 1 : 0; 
        }
        
        return count;
    }
}