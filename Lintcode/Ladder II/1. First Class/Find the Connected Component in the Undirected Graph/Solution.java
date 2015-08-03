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
    class UnionFind {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        UnionFind(HashSet<Integer> set) {
            for (Integer now : hashSet) {
                map.put(now, now);
            }
        }
        
        private int find(int node) {
            int res = map.get(node);
            while(res != map.get(node)) {
                res = map.get(node);
                node = res;
            }
            return res;
        }
        
        private int union(int nodeOne, int nodeTwo) {
            int parentOfNodeOne = find(nodeOne);
            int parentOfNodeTwo = find(nodeTwo);
            if (parentOfNodeOne != parentOfNodeTwo) {
                map.put(parentOfNodeTwo, parentOfNodeOne);
            }
        
        }
    }
    
    List<List<Integer>> print(HashSet<Integer> set, UnionFInd uf, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for (int i : set) {
            int fa = uf.find(i);
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = hashMap.get(fa);
            now.add(i);
            hashMap.put(fa, now);
        }
        
        for (List<Integer> now: hashMap.values()) {
            Collections.sort(now);
            ans.add(now);
        }
        return ans;
    }
    

    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (UndirectedGraphNode now : nodes) {
            hashSet.add(now.label);
            for (UndirectedGraphNode neighbor : now.neighbors) {
                hashSet.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(hashSet);
        
        for (UndirectedGraphNode now : nodes) {
            for (UndirectedGraphNode neighbor : now.neighbors) {
                int fnow = uf.find(now.label);
                int fneighbor = uf.find(neighbor.label);
                if (fnow != fneighbor) {
                    uf.union(now.label, neighbor.label);
                }
            }
        }
        
        return print(hashSet, uf, nodes.size());
            
        
    }
    
    
}
