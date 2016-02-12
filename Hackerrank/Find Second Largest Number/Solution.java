class Solution{
	public int findSecondLargest(int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > first) {
				second = first;
				first = nums[i];
			} else if (nums[i] > second) {
				second = nums[i];
			}
		}

		return second;
	}
}