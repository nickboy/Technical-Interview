public class NaiveSolution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i <= rowIndex; i++) {
            Integer[] curRow = new Integer[i + 1];
            Arrays.fill(curRow, 1);
            for (int j = 1; j < i; j++) {
                List<Integer> lastRow = res.get(res.size() - 1);
                curRow[j] = lastRow.get(j-1) + lastRow.get(j);
            }
            res.add(Arrays.asList(curRow));
        }
        return res.get(res.size() - 1);
    }
}