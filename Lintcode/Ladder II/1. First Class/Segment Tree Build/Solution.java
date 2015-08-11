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
        
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            SegmentTreeNode newNode = new SegmentTreeNode(start, end);
            return newNode;
        }
        
        int mid = (start + end) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        
        return root;

    }
}