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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length != inorder.length) {
            return null;
        }
        
        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
        
        if (instart > inend) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int pos = findPos(inorder, instart, inend, root.val);
        
        // 找出pos之後，inorder很好切，只要把instart到pos-1送給左半邊，把pos+1到inend送給右半邊
        // 而比較難處理是preorder的部份，先算好inoder的左半邊取了幾個數，
        // 接著由preorder的root下一個開始算，取相同各數的值繼續遞迴
        // 右半邊以此類堆
        root.left = helper(inorder, instart, pos - 1, preorder, prestart + 1, prestart + (pos - instart));
        root.right = helper(inorder, pos + 1, inend, preorder, prestart + (pos - instart) + 1, preend);
        
        return root;
    }
    
    //這個只是找出key相對應的位置在哪
    private int findPos(int[] array, int start, int end, int key) {
        
        int i;
        for (i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        
        return -1;
    }
}
