/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class DFSSolution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    // 此題解法，使用dfs來作
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        // 使用visited來紀錄所有訪問過的節點
        // path來紀錄當下經過的節點
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        List<Integer> path = new ArrayList<Integer>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, visited, path); 
                Collections.sort(path); // 排一下結果讓結果一致
                res.add(new ArrayList<Integer>(path)); // 要記得new一個list，否則只會存ref到res裡，紀錄會被蓋掉
                path.clear(); //把path清空，下一輪的dfs可以繼續用
            }
        }
        return res;
    }
    
    //把該點加入path，接著遍歷所有neighbor，若還有沒被訪問過的，則繼續dfs
    private void dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited, List<Integer> path) {
        visited.add(node);
        path.add(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs (neighbor, visited, path);
            }
        }
        
    }
}
