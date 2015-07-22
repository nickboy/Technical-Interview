class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        //因會overflow，所以使用long，之後再轉成int
        long sum = 0;
        for (int i = 0; i < key.length; i++) {
            sum = (sum * 33 + (int)key[i]) % HASH_SIZE;
            if (sum < 0) {
                sum = Integer.MAX_VALUE;
            }
        }
        return (int) sum;
    }
};
