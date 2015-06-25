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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        helper(res, root, k1, k2);
        return res;
    }
    
    private void helper(ArrayList<Integer> res, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val > k1 ) {
            helper(res, root.left, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        if (root.val < k2) {
            helper(res, root.right, k1, k2);
        }
        
    }
}
