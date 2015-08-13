/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    class SegmentTreeNode {
        int start; 
        int end;
        int min;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            this.left = null;
            this.right = null;
        }
    }
    
    private void modifyST(SegmentTreeNode root, int index, int value) {
        
        if (root.start == index && root.end == index) {
            root.min = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        
        if (index <= mid) {
            modifyST(root.left, index, value);
        } else {
            modifyST(root.right, index, value);
        }
        
        return root.min = Math.min(root.left.min, root.right.min);
    }
    
    private SegmentTreeNode buildST (int A[], int start, int end) {
        
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        
        if (start == end) {
            root.min = A[start];
            return root;
        }
        
        int mid = (start + end) / 2;
        
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
        
        return root;
    }
    
    private int queryST (SegmentTreeNode root, int start, int end) {
        
        if (start == root.start && end == root.end ) {
            return root.min;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        
        if (start <= mid) {
            if (end > mid) {
                leftMin = query(root.left, start, mid);
            } else {
                leftMin = query(root.left, start, end);
            }
        }
        
        if (end > mid) {
            if (start <= mid) {
                rightMin = query(root.right, mid + 1, end);
            } else {
                rightMin = query(root.right, start, end);
            }
        }
        
        return Math.min(leftMin, rightMin);
        
    }
    
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (A == null || A.length == 0) {
            return res;
        }
        
        SegmentTreeNode root = buildTree(a, 0, A.length - 1);
        for (Interval query : queries) {
            int min = queryST(query.start, query.end);
            res.add(min);
        }
        
        return res;
        
    }
}
