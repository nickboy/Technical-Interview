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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    HashMap<Integer, Integer> map;
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        map = new HashMap<Integer, Integer>();
        for (DirectedGraphNode node : nodes) {
            map.put(node.label, node.label);
        }
        
        for (DirectedGraphNode node : nodes) {
            int parent = find(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                int parentNeighbor = find(neighbor);
                if (parent != parentNeighbor) {
                    union(node, neighbor);
                }
            }
        }
        return print(nodes);
        
    }
    
    //將兩個集合合併起來
    private void union(int nodeOne, int nodeTwo) {
        int parentOne = find(nodeOne);
        int parentTwo = find(nodeTwo);
        if (parentOne != parentTwo) {
            map.put(parentTwo, parentOne);
        }
    }
    //不斷往上找到老大哥
    private int find(int node) {
        int res = map.get(node);
        while (res != map.get(node)) {
            res = map.get(node);
            node = res;
        }
        return res;
    }
    
    // 利用整理好的map，來產出正確的結果
    // 1.歷遍原本的map，來建立另一個set的mapping (resMap) key為father，value為該component的集合
    // 2.
    private List<List<Integer>> print(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> resMap = new HashMap<Integer, ArrayList<Integer>>();
        for (DirectedGraphNode node : nodes) {
            int parent = find(node);
            if (!resMap.containsKey(parent)) {
                resMap.put(parent, new ArrayList<Integer>());
            }
            List<Integer> list = resMap.get(parent);
            list.add(node.label);
            resMap.put(parent, list);
        }
        
        for (List<Integer> now : resMap.values()) {
            Collections.sort(now);
            result.add(now);
        }
        return result;
    }
}
