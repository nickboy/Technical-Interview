public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // start之所以從A.length/2開始，是因為要從Internal node開始，
        // 除開最後一行。其實可以寫成start = (A.length - 1 - 1) / 2, 
        // 求最後一個index的parent index的基本做法。
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
    
    private void siftdown(int[] A, int k) {
        int smallest = k;
        int len = A.length;
        //k代表是root，接著不斷拿root去與左右子樹的root比，若子樹的值較小，
        //則與k交換，接著k指向到被交換的點，就是不斷去追縱一開始的ROOT
        //請注意，比的是值，smallest紀錄的是當前最小值的index
        while ( k < len) {
            if (k * 2 + 1 < len && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < len && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            
            int temp = A[k];
            A[k] = A[smallest];
            A[smallest] = temp;
            k = smallest;
        }
    }
}
