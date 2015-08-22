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
    HashMap<DirectedGraphNode, DirectedGraphNode> father = new HashMap<DirectedGraphNode, DirectedGraphNode>();
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (DirectedGraphNode node : nodes) {
            father.put(node, node);
        }
        
        for (DirectedGraphNode node : nodes) {
            DirectedGraphNode fatherA = find(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                DirectedGraphNode fatherB = find(neighbor);
                if (fatherA != fatherB) {
                    union(fatherA, fatherB);
                }
            }
        }
        
        HashMap<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();
        for (DirectedGraphNode node : nodes) {
            DirectedGraphNode father = find(node);
            if (!children.containsKey(father.label)) {
                children.put(father.label, new ArrayList<Integer>());
            }
            children.get(father.label).add(node.label);
        }
        
        for (List<Integer> childList : children.values()) {
            List<Integer> tempRes = new ArrayList<Integer>();
            for (int child : childList) {
                tempRes.add(child);
            }
            Collections.sort(tempRes);
            res.add(tempRes);
        }
        
        return res;
    }
    
    private DirectedGraphNode find(DirectedGraphNode node) {
        DirectedGraphNode parent = father.get(node);
        
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        
        return parent;
    }
    
    private void union(DirectedGraphNode a, DirectedGraphNode b) {
        DirectedGraphNode fatherA = find(a);
        DirectedGraphNode fatherB = find(b);
        if (fatherA != fatherB) {
            father.put(fatherA, fatherB);
        }
    }
    
    
}
