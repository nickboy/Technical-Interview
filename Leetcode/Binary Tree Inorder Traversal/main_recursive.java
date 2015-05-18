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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversalHelper(root, list);
        return list;
        
    }
    public void inorderTraversalHelper(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorderTraversalHelper(root.left,list);
        list.add(root.val);
        inorderTraversalHelper(root.right,list);
    }
}