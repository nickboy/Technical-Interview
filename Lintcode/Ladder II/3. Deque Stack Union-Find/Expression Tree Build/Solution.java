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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(A[0]));
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < stack.peek().val) {
                TreeNode node = new TreeNode(A[i]);
                stack.push(node);
            } else {
                // 因是max tree，所以stack內是降序的，所以一但當前的數比stack頂端的值還大，
                //就要不斷的pop出來，由於越在stack底部的數值一定是在陣列的左邊，所以要不斷的pop直到當前值小於stack的peek。
                // 且每次pop，就要不斷把pop出來的值的右邊指向之前那個點
                
                TreeNode n1 = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < A[i]) {
                    
                    TreeNode n2 = stack.pop();
                    n2.right = n1;
                    n1 = n2;
                }
                TreeNode node = new TreeNode(A[i]);
                node.left = n1;
                stack.push(node);
            }
        }
        // 如果stack還有剩的話，就不斷pop出來，且因為
        TreeNode head = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            temp.right = head;
            head = temp;
        }
        
        return head;
    }
}
