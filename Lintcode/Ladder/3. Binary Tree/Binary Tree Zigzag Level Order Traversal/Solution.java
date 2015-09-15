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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> curLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        curLevel.push(root);
        boolean leftToRight = true;
        
        while (!curLevel.isEmpty()) {
            ArrayList<Integer> tempRes = new ArrayList<Integer>();
            
            while (!curLevel.isEmpty()) {
                TreeNode cur = curLevel.pop();
                tempRes.add(cur.val);
                
                if (leftToRight) {
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                }
            }
            res.add(tempRes);
            Stack<TreeNode> temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            leftToRight = !leftToRight;
            
        }
        
        return res;
    }
}
