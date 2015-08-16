public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
     
    public class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    
    
    private void modifyST(SegmentTreeNode root, int value) {
        
        if (root.start == value && root.end == value) {
            root.count++;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (value <= mid) {
            modifyST(root.left, value);
        } else {
            modifyST(root.right, value);
        }
        
        root.count = root.left.count + root.right.count;
        
    }
    
    private int queryST(SegmentTreeNode root, int start, int end) {
        
        if (root.start == start && root.end == end) {
            return root.count;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftCount = 0;
        int rightCount = 0;
        
        if (start <= mid) {
            if (end > mid) {
                leftCount = queryST(root.left, start, mid);
            } else {
                leftCount = queryST(root.left, start, end);
            }
        }
        
        if (end > mid) {
            if (start <= mid) {
                rightCount = queryST(root.right, mid + 1, end);
            } else {
                rightCount = queryST(root.right, start, end);
            }
        }
        
        return leftCount + rightCount;
    }
    
    private SegmentTreeNode buildST(int start, int end) {
        
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        
        if (!(start == end)) {
            int mid = (start + end) / 2;
        
            if (start <= mid) {
                root.left = buildST(start, mid);
            } 
            if (end > mid) {
                root.right = buildST(mid + 1, end);
            }
        }
        
        return root;
    }
    
    SegmentTreeNode root;
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (A == null || A.length == 0) {
            return res;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            min = A[i] < min ? A[i] : min;
            max = A[i] > max ? A[i] : max;
        }
        
        root = buildST(min, max);
        
        for (int i = 0; i < A.length; i++) {
            int answer = queryST(root, min, A[i]-1);
            res.add(answer);
            modifyST(root, A[i]);
        }
        
        return res;
        
        
        
    }
}

