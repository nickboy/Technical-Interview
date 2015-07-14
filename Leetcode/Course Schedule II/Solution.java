public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int resIdx = 0;

        // 得搞清楚destination與source的方向
        // pre[i][0] : destination
        // pre[i][1] : source
        
        //計算indegree
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]] += 1;
        }
        
        //建一個queue來作bfs，接著把indegree為0的點加入res與queue中
        //用resIdx來控制res的指標
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                res[resIdx++] = i;
            }
        }
        
        
        //每次從queue中取出一個indegree為0的點，
        //接著traverse pre來找出對應的desitnation
        //把destination的indegree扣1
        //若indegree變0了，把該neighbor加入queue與res中
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curNode) {
                    inDegree[prerequisites[i][0]] -= 1;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        res[resIdx++] = prerequisites[i][0];
                    }
                }
            }
            
        }
        
        //得check是否有解，若無解則回傳一個空陣列
        if (resIdx != numCourses) {
            return new int[0];
        } else {
            return res;
        }
    }
}