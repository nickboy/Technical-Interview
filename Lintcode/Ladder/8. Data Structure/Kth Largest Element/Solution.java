class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return 0;
        }
        return quickSelect(numbers, 0, numbers.size() - 1, numbers.size() - k);
    }
    
    private int quickSelect(ArrayList<Integer> nums, int left, int right, int k) {
        int pivot = right;
        int num = nums.get(pivot);
        int low = left;
        int high = right;
        
        while (low < high) {
            //從low開始找到一個比pivot大的數
            while (low < high && nums.get(low) < num) {
                low++;
            }
            // 從high開始找到一個比pivot小的數
            // 設>=表示忽略pivot
            while (low < high && nums.get(high) >= num) {
                high--;
            }
            swap(nums, low, high);
        }
        // 交換pivot與目前high指向的位置
        // 因pivot選最後一位，因此必須選一個比pivot大的數來作交換
        // 此時low指針已high指針已重疊，即該數大於pivot，直接作交換
        swap(nums, low, pivot);
        
        if (low == k) {
            return nums.get(low);
        }
        if (low > k) {
            return quickSelect(nums, left, low - 1, k);
        } else {
            //因為陣列的index都還在，所以直接丟k進去即可
            return quickSelect(nums, low + 1, right, k);
        }
        
    }
    
    private void swap (ArrayList<Integer> numbers, int idxA, int idxB) {
        int temp = numbers.get(idxA);
        numbers.set(idxA, numbers.get(idxB));
        numbers.set(idxB, temp);
    }
};
