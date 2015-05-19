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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //use long to avoid overflow or extremely cases.
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    public boolean helper(TreeNode root, long lower, long upper){
        if(root == null) return true;
        //check if the value of root is in the certain range.
        if(root.val<=lower || root.val>=upper) return false;
        //keep check left and right sub trees.
        return helper(root.left,lower,root.val) && helper(root.right,root.val,upper);
    }
}