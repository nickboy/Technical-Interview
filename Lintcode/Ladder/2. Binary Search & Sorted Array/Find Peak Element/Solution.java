class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here

        int start = 1;
        int end = A.length - 2;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            //拿mid與兩邊比小，若mid比左邊小，代表左邊有峰值
            //若mid比右邊小，代表右邊有峰值
            //若else，代表mid比左邊大，且比右邊大，則mid本身可能是峰值。
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}

