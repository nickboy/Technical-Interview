/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return isBST(root.left, Integer.MIN_VALUE, root.val) && 
                isBST(root.right, root.val, Integer.MAX_VALUE);
    }
    
    public boolean isBST(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }
        if (root.val > lower && root.val < upper) {
            return isBST(root.left, lower, root.val) &&
                    isBST(root.right, root.val, upper);
        } else {
            return false;
        }
    }
}
