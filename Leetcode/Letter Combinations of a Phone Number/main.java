public class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0)
            return list;
        StringBuilder tempResult = new StringBuilder(digits.length());
        helper(digits, tempResult, 0, list, map);
        return list;
    }
    
    public void helper(String digits, StringBuilder tempResult, int index, List<String> list, String[] map) {
        if (index == digits.length()) {
            list.add(tempResult.toString());
            return;
        } else {
            String currentLetters = map[digits.charAt(index) - '0']; //grab the letters from map with current digit
            for(int i = 0; i < currentLetters.length(); i++) {
                //append a char in the end of temp result
                //recursive call
                //delete the append char.
                tempResult.append(currentLetters.charAt(i));
                helper(digits, tempResult, index + 1, list, map);
                tempResult.deleteCharAt(tempResult.length() - 1);
            }
        }
    }
}