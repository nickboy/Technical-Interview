public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int len = A.length;
        int result = 0;
        // 先把所有數都xor起來，會得到a^b
        for (int i = 0; i < len; i++) {
            result ^= A[i];
        }
        
        // 接著用這個方法來找出最後一個不一樣的位元
        // 靠這個位元來決定每個數要放到哪個group
        // 等於轉成兩個2n+1的問題來解
        // 之後把這兩個值加到list回傳即可
        // result & (result - 1) 會把最後一個1去掉
        // 再用result去減可以得到最後一個1
        // 接著直接去比這個bit即可
        int lastBit = result - (result & (result - 1));
        int group1 = 0;
        int group2 = 0;
        for (int i = 0; i < len; i++) {
            if ((A[i] & lastBit) == 0) {
                group1 ^= A[i];
            } else {
                group2 ^= A[i];
            }
        } 
        List<Integer> list = new ArrayList<Integer>();
        list.add(group1);
        list.add(group2);
        
        return list;
    }
}
