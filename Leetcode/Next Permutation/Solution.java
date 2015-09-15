public class Solution {
    public void nextPermutation(int[] nums) {
        
        if (nums == null || nums.length < 2) {
            return;
        } 
        
        int len = nums.length;
        int pivot = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        if (pivot != -1) {
            for (int i = len - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, i, pivot);
                    break;
                }
            } 
        }
        
        reverse(nums, pivot + 1, len - 1);
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
}