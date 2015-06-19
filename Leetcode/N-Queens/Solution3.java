class Solution3 {
	public void permuteHelper (ArrayList<ArrayList<String>> answer, ArrayList<Integer> list, 
								ArrayList<Integer> nums, int n) {
		if (list.size() == n ) {
			answer.add(drawBoard(new ArrayList<Integer>(list)));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			if (!isValid(list, nums.get(i))) {
				continue;
			}

			list.add(nums.get(i));
			nums.remove(i);
			permuteHelper(answer, list, nums, n);
			nums.add(i, list.get(list.size()-1));
			list.remove(list.size() - 1);
		}
	}
}