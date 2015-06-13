/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode rootInClass;
    public BSTIterator(TreeNode root) {
        rootInClass = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (rootInClass != null && rootInClass.right != null);
    }

    /** @return the next smallest number */
    public int next() {
        if (rootInClass.right == null)
            return 0;
        TreeNode cur = rootInClass.right;
        int result = 0;
        while(cur != null) {
            result = cur.val;
            cur = cur.left;
        }
        
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */