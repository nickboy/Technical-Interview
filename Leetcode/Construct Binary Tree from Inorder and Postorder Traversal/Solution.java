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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        
        if (instart > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postend]);
        int pos = findPosition(inorder, instart, inend, root.val);
        
        root.left = helper(inorder, instart, pos - 1, postorder, poststart, poststart + pos - instart - 1);
        root.right = helper(inorder, pos + 1, inend, postorder, postend - (inend - pos), postend - 1);
        
        return root;
    }
    
    private int findPosition(int[] array, int start, int end, int key) {
        
        int i;
        for (i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        
        return -1;
    }
}
