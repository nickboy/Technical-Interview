/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph.size() == 0) {
            return res;
        }
        
        // 計算每個點的in degree
        // 因為是要計算每個點的indegree，因此不能使用每個點的neighbors.size()
        // 得老實的慢慢算，不然會錯，卡在這裡好一陣子，記得這個細節。
        HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (inDegree.containsKey(neighbor)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                } else {
                    inDegree.put(neighbor, 1);
                }
            }
        }
        
        // 把其中一個inDegree為0的點加到queue中
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!inDegree.containsKey(node)) {
                queue.add(node);
                res.add(node);
            }
        }
        
        // 開始作topology sort，由indegree 為0的點開刀，
        // 把indegree 為0 的點的所有neighbor indegree 都減1
        // 若該neighbor的indegree為0 時，則加入queue與result。
        // 直到queue為空為止
        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode neighbor : curNode.neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    res.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return res;
        
        
    }
}
