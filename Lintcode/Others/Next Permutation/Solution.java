public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        int len = nums.length;
        int pivot = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        // 這題難在如何處理邊際條件
        // 如果pivot等於-1的話，代表目前的排列為降序，且是最後一個排列，
        // 若不等於-1，則代表pivot右邊至少存在一數比pivot大，找到它並與pivot交換
        // 此作法是把pivot的右側調整為降序
        if (pivot != -1) {
            for (int i = len - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, i, pivot);
                    break;
                }
            }
        }
        
        // 把pivot的右邊作翻轉(即排成升序)即可，因pivot的右邊為降序
        reverse(nums, pivot + 1, len - 1);
        
        return nums;
    }
    
    private void swap (int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
