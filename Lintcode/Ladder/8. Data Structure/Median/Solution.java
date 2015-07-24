public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        int len = nums.length;

        if (len % 2 == 1) {
            return quickSelect(nums, 0, len - 1, len / 2);
        } else {
            return quickSelect(nums, 0, len - 1, len / 2 - 1);
        }
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = right;
        int num = nums[pivot];
        int low = left;
        int high = right;
        
        while (low < high) {
            //從low開始找到一個比pivot大的數
            while (low < high && nums[low] < num) {
                low++;
            }
            // 從high開始找到一個比pivot小的數
            // 設>=表示忽略pivot
            while (low < high && nums[high] >= num) {
                high--;
            }
            swap(nums, low, high);
        }
        // 交換pivot與目前high指向的位置
        // 因pivot選最後一位，因此必須選一個比pivot大的數來作交換
        // 此時low指針已high指針已重疊，即該數大於pivot，直接作交換
        swap(nums, low, pivot);
        
        if (low == k) {
            return nums[low];
        }
        if (low > k) {
            return quickSelect(nums, left, low - 1, k);
        } else {
            //因為陣列的index都還在，所以直接丟k進去即可
            return quickSelect(nums, low + 1, right, k);
        }
        
    }
    
    private void swap(int[] nums, int idxA, int idxB) {
        int temp = nums[idxA];
        nums[idxA] = nums[idxB];
        nums[idxB] = temp;
    }
}

