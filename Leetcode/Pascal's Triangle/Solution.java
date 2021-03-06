public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (numRows == 0) {
            return res;
        }
        
        for (int i = 0; i < numRows; i++) {
            Integer[] curRow = new Integer[i + 1];
            Arrays.fill(curRow, 1);
            
            // 忽略前後兩個數
            // 從後面開始算，以避免值被蓋掉
            for (int j = 1; j < i; j++) {
                List<Integer> lastRow = res.get(res.size() - 1);
                curRow[j] = lastRow.get(j - 1) + lastRow.get(j);
            }
            res.add(Arrays.asList(curRow));
        }
        
        return res;
    }
}