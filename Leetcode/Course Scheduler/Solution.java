public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
        int len = prerequisites.length;
        if(numCourses<=1)
            return true;
        
        for(int i=0; i<len; i++){
            int source = prerequisites[i][0];
            int destination = prerequisities[i][1];
            if(!graph.containsKey(source)){
                List<Integer> list = new List<Integer>();
                list.append(destination);
                graph.put(source, list);
            }else{
                graph.get(destination).append(destination);
            }        
        }
        
    }
}