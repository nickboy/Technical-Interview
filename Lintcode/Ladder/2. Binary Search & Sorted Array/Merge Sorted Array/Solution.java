class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        // 從後面倒過來作
        int posA = m - 1;
        int posB = n - 1;
        int idx = m + n - 1;
        while (posA >= 0 && posB >= 0) {
            if (A[posA] > B[posB]) {
                A[idx--] = A[posA--];
            } else {
                A[idx--] = B[posB--];
            }
        }
        //處理剩下的element
        while (posA >= 0) {
            A[idx--] = A[posA--];
        }
        while (posB >= 0) {
            A[idx--] = B[posB--];
        }
    }
}
