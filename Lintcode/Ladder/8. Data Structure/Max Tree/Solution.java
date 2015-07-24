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

    //這個題Leetcode上沒有，其實這種樹叫做笛卡樹（ Cartesian tree）。
    //直接遞歸建樹的話複雜度最差會退化到O(n^2)。
    //經典建樹方法，用到的是單調堆棧。我們堆棧裡存放的樹，只有左子樹，沒有有子樹，且根節點最大。
    //（1） 如果新來一個數，比堆棧頂的樹根的數小，則把這個數作為一個單獨的節點壓入堆棧。
    //（2） 否則，不斷從堆棧裡彈出樹，新彈出的樹以舊彈出的樹為右子樹，連接起來，直到目前堆棧頂的樹根的數大於新來的數。
    //      然後，彈出的那些數，已經形成了一個新的樹，這個樹作為新節點的左子樹，把這個新樹壓入堆棧。

    // 這樣的堆棧是單調的，越靠近堆棧頂的數越小。
    // 最後還要按照（2）的方法，把所有樹彈出來，每個舊樹作為新樹的右子樹。
    
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(A[0]));
        
        for (int i = 1; i < A.length; i++) {
            // stack 的各個點一定是最小在最上面
            // 若該數比stack最上面那個還小，直接建新node再push進stack即可
            if (A[i] < stack.peek().val) {
                TreeNode node = new TreeNode(A[i]);
                stack.push(node);
            } else {
                // 因該數比stack最上面的數還要大，因此要不斷pop到比該數小為止，
                // 其中不斷把pop出來的數合到該數的右子樹
                TreeNode n1 = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < A[i]) {
                    TreeNode n2 = stack.pop();
                    n2.right = n1;
                    n1 = n2;
                }
                // 接下來把前面那些子樹合到此node的左子樹再push回stack
                TreeNode node = new TreeNode(A[i]);
                node.left = n1;
                stack.push(node);
            }
        }
        // 再來要把stack剩下的子樹們不斷的合成，最後回傳head即可
        TreeNode head = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            temp.right = head;
            head = temp;
        }
        
        return head;
    }
}
