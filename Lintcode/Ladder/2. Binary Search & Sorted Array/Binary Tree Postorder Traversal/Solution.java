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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null && cur.right == null) {
                stack.pop();
                res.add(cur.val);
            }
            //先加右邊的，因為是stack，左邊會先被pop出來
            //接著把cur的right指標設為null，表示已traverse過右邊了。
            if (cur.right != null) {
                stack.push(cur.right);
                cur.right = null;
            }
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            }
        }
        return res;
        
    }
}
