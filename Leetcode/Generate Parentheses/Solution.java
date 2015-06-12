public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        helper(n, n, result, new String());
        return result;
        
    }
    
    public void helper(int left, int right, List<String> result, String str) {
        //number of left parenthesis must be greater than right
        //number of right parenthesis is greater than left
        //just return without anythin.
        if(left > right) {
            return;
        }
        
        //if reach the target, add the string into result.
        if(left == 0 && right == 0) {
            result.add(str);
        }
        //keep call recursive function and add the other parenthesis into string.
        if (left > 0) {
            helper(left-1, right, result, str+"(");
        }
        if (right > 0) {
            helper(left, right-1, result, str+")");
        }
    }
}