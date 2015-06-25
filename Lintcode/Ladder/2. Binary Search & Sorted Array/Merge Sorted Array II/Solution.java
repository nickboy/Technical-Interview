class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            return B;
        }
        if (B == null || B.size() == 0) {
            return A;
        }
        
        int pointA = 0;
        int pointB = 0;
        while (pointA < A.size() && pointB < B.size()) {
            if (A.get(pointA) <= B.get(pointB)) {
                res.add(A.get(pointA++));
            } else {
                res.add(B.get(pointB++));
            }
        }
        while (pointA < A.size()) {
            res.add(A.get(pointA++));
        }
        while (pointB < B.size()) {
            res.add(B.get(pointB++));
        }
        
        return res;
     }
}
