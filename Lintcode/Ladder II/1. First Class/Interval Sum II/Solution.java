public class Solution {
    
    class SegmentTreeNode {
        public int start, end, sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = null;
            this.right = null;
        }
    }
    

    /**
     * @param A: An integer array
     */
    SegmentTreeNode root;
    public Solution(int[] A) {
        root = buildST(0, A.length, A);
    }
    
    
    public SegmentTreeNode buildST(int start, int end, int[] A) {
        
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if (start == end) {
            root.sum = A[start];
        } else {
            int mid = (root.start + root.end) / 2;
            root.left = buildST(start, mid, A);
            root.right = buildST(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        }
        
        return root;
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        
        return queryST(root, start, end);
    }
    
    public int queryST(SegmentTreeNode root, int start, int end) {
        
        if (start > end) {
            return 0;
        }
        
        if (root.start == start || root.end == end) {
            return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftSum = 0;
        int rightSum = 0;
        
        if (start <= mid) {
            if (end > mid) {
                leftSum = queryST(root.left, start, mid);
            } else {
                leftSum = queryST(root.right,start, end);
            }
        }
        
        if (end > mid) {
            if (start <= mid) {
                rightSum = queryST(root.right, mid + 1, end);
            } else {
                rightSum = queryST(root.right, start, end);
            }
        }
        
        return leftSum + rightSum;
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modifyST(root, index, value);
    }
    
    public void modifyST(SegmentTreeNode root, int index, int value) {
        
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        
        root.sum = root.left.sum + root.right.sum;
    }
}

