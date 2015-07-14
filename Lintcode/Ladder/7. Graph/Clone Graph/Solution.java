/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        //建一個hashmap來對應新點跟舊點的關係，若點在hashmap中，代表已拜訪過
        //再用一個queue來作bfs
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode oldNode = queue.poll();
            
            //拜訪所有的neighbors，若不在map裡，則新建一個new node並加到map中，
            //並把該neighbor加入queue中，等待下一次的拜訪
            //接著再把新neighbor加入新node的neighbor list中。
            for (int i = 0; i < oldNode.neighbors.size(); i++) {
                UndirectedGraphNode oldNeighbor = oldNode.neighbors.get(i);
                if (!map.containsKey(oldNeighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                    map.put(oldNeighbor, newNeighbor);
                    queue.add(oldNeighbor);
                } 
                map.get(oldNode).neighbors.add(map.get(oldNeighbor));
            }

        }
        return map.get(node);
    }
}
