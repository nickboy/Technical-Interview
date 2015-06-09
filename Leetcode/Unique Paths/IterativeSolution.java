//1, 1, 1, 1
//1, 2, 3, 4
//1, 3, 6, 10
//1, 4, 10, |20| <--- this is the result

public class IterativeSolution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //use an one dimensional array to record the result of previous iteration
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            //start from 1 to avoid null pointer issue
            for (int j = 1; j < n; j++) {
                res[j] += res[j-1];
            }
        }
        return res[n-1];
    }
}
