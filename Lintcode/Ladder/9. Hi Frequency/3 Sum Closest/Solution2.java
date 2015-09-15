public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
public int threeSumClosest(int[] numbers ,int target) {
    
    if (numbers == null || numbers.length == 0) {
        return 0;
    }
    
    Arrays.sort(numbers);
    int minDiff = Integer.MAX_VALUE;
    int result = 0;
    
    for (int i = 0; i < numbers.length - 2; i++) {
        
        int start = i + 1;
        int end = numbers.length - 1;;
        
        while (start < end) {
            
            int curSum = numbers[i] + numbers[start] + numbers[end];
            int diff = Math.abs(target - curSum);
            
            if (diff < minDiff) {
                result = curSum;
                minDiff = diff;
            }
            
            // 只移動單一pointer，與3Sum不同，因此題是找最接近的，
            // 如果兩個pointer皆移動的話，可能會遺漏可能的結果。
            if (curSum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
    
    return result;
}
}

