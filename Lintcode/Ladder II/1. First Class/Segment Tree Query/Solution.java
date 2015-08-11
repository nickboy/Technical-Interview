/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.max;
        }
        
        int mid = (root.start + root.end) / 2; 
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        // 左半邊
        // 因往左半邊搜的upper bound是mid
        // 因此檢查是否start <= mid
        if (start <= mid) {
            // 如果end比mid小的話，則表示只需找右半邊，且不需分裂
            // 若比end比mid大的話，則右邊也有值要查找，
            if (end < mid) {
                leftMax = query(root.left, start, end);
            } else {
                leftMax = query(root.left, start, mid);
            }
        }
        
        // 右半邊
        // 因右半邊的lower bound是mid+1，所以要確保end有大於mid
        if (end > mid) {
            // 如果start有小於或等於mid的話，代表左半邊也有值要查找，
            // 直接從mid+1到end找，再與左半邊合併
            // 若start比mid大，代表一定所有可能值一定在右半邊
            if (start <= mid) {
                rightMax = query(root.right, mid + 1, end);
            } else {
                rightMax = query(root.right, start, end);
            }
        }
        
        return Math.max(leftMax, rightMax);
    }
}
