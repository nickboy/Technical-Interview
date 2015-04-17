/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        boolean isDepthBalanced = Math.abs(maxDepth(root.right)-maxDepth(root.left))<=1;
        return isBalanced(root.right) && isBalanced(root.left) && isDepthBalanced;
    }
    
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
