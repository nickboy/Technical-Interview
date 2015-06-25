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
    public class ResultType {
        int singlePath;
        int maxPath;
        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultType res = helper(root);
        return res.maxPath;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int singlePath = Integer.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Integer.max(0, singlePath);
        
        int maxPath = Integer.max(left.maxPath, right.maxPath);
        maxPath = Integer.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }
}