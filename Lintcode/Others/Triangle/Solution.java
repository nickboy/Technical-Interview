public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int candidateOne = triangle.get(i+1).get(j);
                int candidateTwo = triangle.get(i+1).get(j+1);
                int minCost = Math.min(candidateOne, candidateTwo) + triangle.get(i).get(j);
                triangle.get(i).set(j, minCost);
            }
        }
        
        return triangle.get(0).get(0);
    }
}