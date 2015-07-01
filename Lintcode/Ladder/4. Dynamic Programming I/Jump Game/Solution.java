public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int len = A.length;
        if (len == 0 || A[0] == 0) {
            return false;
        }
        
        boolean[] canArrive = new boolean[len];
        canArrive[0] = true;
        
        for (int i = 0; i<len; i++) {
            int steps = A[i];
            for (int j = 1; j <= steps; j++) {
                if (i + j < len && canArrive[i])
                    canArrive[i + j] = true;
            }
        }
        return canArrive[len - 1];
    }
}