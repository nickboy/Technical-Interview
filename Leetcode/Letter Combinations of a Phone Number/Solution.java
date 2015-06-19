public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        
        String[] map = new String[] { " "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" };
        StringBuilder tempRes = new StringBuilder();
        
        helper (digits, res, tempRes, 0, map);
        return res;
    }
    
    private void helper (String digits, List<String> res, StringBuilder tempRes, int pos, String[] map) {
        if (pos == digits.length()) {
            res.add(tempRes. toString());
            return;
        }
        for (int i = pos; i < digits.length(); i++) {
            String curStr = map[digits.charAt(i) - '0'];
            for (int j = 0; j < curStr.length(); j++) {
                tempRes.append(curStr.charAt(j));
                helper(digits, res, tempRes, i + 1, map);
                tempRes.deleteCharAt(tempRes.length() - 1);
            }
        }
    }
}