/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        root.next = null;
        helper(root);
    }
    
    private void helper(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            //determine weather root.next is null or not, set pointer of right.next to null or root.next.left
            root.right.next = (root.next == null)? null:root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}