/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IterativeSolution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode node = root;
        TreeNode parent = null;
        TreeNode right = null;
        
        while (node != null) {
            //Remember the original left treenode.
            TreeNode left = node.left;
            
            // change the left pointer to right and move right pointer to right
            node.left = right;
            right = node.right;
            // change the right pointer to parent and move parent pointer to node
            node.right = parent;
            parent = node;
            // move the cursor to origin left
            node = left;
        }
        
        return parent;
    }
}