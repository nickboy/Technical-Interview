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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        if (!stack.isEmpty()) {
            TreeNode res = stack.peek();
            TreeNode node = stack.pop();
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return res;
        }
        return null;
    }
}
