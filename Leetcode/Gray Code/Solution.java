public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n < 0) {
            return result;
        }
        result.add(0);
        if (n == 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            int length = result.size();
            int highestBit = 1 << i;
            
            //read the values from previous step in reverse order then append 1<<i 
            for (int j = length -1; j >= 0; j--) {
                result.add(result.get(j) + highestBit);
            }
        }
        return result;
    }
}