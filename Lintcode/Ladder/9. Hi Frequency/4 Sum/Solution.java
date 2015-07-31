public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    //我的解法，但會有重複的
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {    
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(numbers[i]);
                pair.add(numbers[j]);
                if (map.containsKey(sum)) {
                    map.get(sum).add(pair);
                } else {
                    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                    list.add(pair);
                    map.put(sum, list);
                }
            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (map.containsKey(target - sum)) {
                    ArrayList<ArrayList<Integer>> candidates = map.get(target - sum);
                    for (ArrayList<Integer> candidate : candidates) {
                        if (candidate.get(0) != numbers[i] && candidate.get(1) != numbers[j]) {
                            ArrayList<Integer> subRes = new ArrayList<Integer>();
                            subRes.add(numbers[i]);
                            subRes.add(numbers[j]);
                            subRes.add(candidate.get(0));
                            subRes.add(candidate.get(1));
                            res.add(subRes);
                        } 
                    }
                }
            }
        }
        
        return res;
    }


    // 九章解法
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {    
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        //排序很重要，如果要用雙指針的話
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j-1]) {
                    continue;
                }
                // 先固定好i,j接著j後面的數用雙指針來不斷搜尋
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        // target == sum因此把結果加到res中
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(numbers[i]);
                        tmp.add(numbers[j]);
                        tmp.add(numbers[left]);
                        tmp.add(numbers[right]);
                        res.add(tmp);
                        left++;
                        right--;
                        //避免重複的，因此要不斷check
                        while (left < right && numbers[left] == numbers[left-1]){
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }


}

