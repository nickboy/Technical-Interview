/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        
        //記得處理corner case，否則會無限遞迴
        if (start > end) {
            return null;
        }
        
        // start == end代表達到leaf，直接產生一個新leaf回傳即可
        if (start == end) {
            SegmentTreeNode newNode = new SegmentTreeNode(start, end);
            return newNode;
        }
        
        // 否則還要繼續遞迴下去，分別遞迴左右子樹之後再回傳
        int mid = (start + end) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        
        return root;

    }
}