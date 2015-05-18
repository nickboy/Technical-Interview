/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int sum = 0;
    
    public void sumNumbersHelper(TreeNode root, int pathValue){
        if (root == null)
            return;
        //current path value from root to current node.
        pathValue = pathValue*10 + root.val;
        
        //add path value into sum when reached leaf node.
        if(root.left == null && root.right == null){
            sum = sum + pathValue;
        }else{
            //recursive call this function for sub trees.    
            sumNumbersHelper(root.left,pathValue);
            sumNumbersHelper(root.right,pathValue);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        int pathValue = 0;
        if(root == null)
            return sum;
        sumNumbersHelper(root, pathValue);
        return sum;
    }
}