public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int len = A.length;
        int[][] res = new int[m+1][len + 1];
        //res[i][j] 代表負重i，可取j種物品中最大的重量
        for (int i = 0; i <=m; i++) {
            res[i][0] = 0;
        }
        
        for (int i = 0; i <= len; i++) {
            res[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= len; j++) {
                //已超重，不取第j個物品，直接抄之前的結果
                if (i < A[j - 1]) {
                    res[i][j] = res[i][j-1];
                } else {
                    //比較取第j個物品還是不取哪個比較好
                    res[i][j] = Math.max(res[i-A[j-1]][j-1] + A[j - 1], res[i][j-1]);
                    if (res[i][j] < max) {
                        max = res[i][j];
                    }
                }
            }
        }
        
        return res[m][len];
    }
}
