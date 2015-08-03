/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        // 因是undirected graph，因此每個點先設自己為father
        for (UndirectedGraphNode node : nodes) {
            map.put(node.label, node.label);
        }
        
        // 接著每個點與自己的neighbor去找各自的父親，若不同則union，若一樣則繼續
        for (UndirectedGraphNode node : nodes) {
            int fnow = find(node.label);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                int fneighbor = find(neighbor.label);
                if (fnow != fneighbor) {
                    union(fnow, fneighbor);
                }
            }
        }
        
        return print(nodes);
        
    }
    
    private void find(int node) {
        int res = map.find(node);
        while (res != map.find(node)) {
            res = map.find(node);
            node = res;
        }
        return res;
    }
    
    private void union(int nodeOne, int nodeTwo) {
        int fOne = find(nodeOne);
        int fTwo = find(nodeTwo);
        if (fOne != fTwo) {
            map.put(fTwo, fOne);
        }
    }
    
    List<List<Integer> >  print(ArrayList<UndirectedGraphNode> nodes) {
	    List<List<Integer>> res = new ArrayList<Integer>();
	    HashMap<Integer, List<Integer>> list = new HashMap<Integer, List<Integer>>();
	    for (UndirectedGraphNode node : nodes) {
	        int fa = find(node.label);
	        if (!list.containsKey(fa)) {
	            list.put(fa, new ArrayList<Integer>());
	        }
	        List<Integer> component = list.get(fa);
	        component.add(node.label);
	        map.put(fa, component);
	    }
	    for (List<Integer> now : list.values()) {
	        Collections.sort(now);
	        res.add(now);
	    }
	    return res;
	}
    
    
}
