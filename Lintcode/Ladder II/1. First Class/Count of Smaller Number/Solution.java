public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (A == null ||  queries == null || queries.length == 0) {
            return res;
        }
        
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (queries[i] > A[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        
        return res;
    }
}

