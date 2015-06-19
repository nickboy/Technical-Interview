public class Solution {
    public int num;
    public List<String[]> solveNQueens(int n) {
        num = n;
        List<String[]> res = new ArrayList<String[]>();
        if (n == 0) {
            return res;
        }
        List<String> tempRes = new ArrayList<String>();
        helper(res, 0, tempRes);
        return res;
    }
    
    private void helper (List<String[]> res, int row, List<String> tempRes) {
        if (num == row) {
            String[] map = tempRes.toArray(new String[tempRes.size()]);
            res.add(map);
            return;
        }
        for (int i = 0 ; i < num; i++) {
            if (isValid(row, i, tempRes)) {
                char[] chars = new char[num];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                tempRes.add(chars.toString());
                helper (res, row + 1, tempRes);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }
    
    private boolean isValid(int row, int col, List<String> tempRes) {
        for (int i = 0; i < row; i++) {
            if ( tempRes.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 &&j >= 0; j--, i--) {
            if (tempRes.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < num; i--, j++) {
            if (tempRes.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}