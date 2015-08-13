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
     
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(HashSet<Integer> hashSet) {
            for (Integer now : hashSet) {
                father.put(now,now);
            }
        }
        
        //找到最上層的父節點
        int find(int x) {
            int parent = father.get(x);
            
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            return parent;
        }
        
        //邊找邊壓縮路徑
        int compressed_find(int x) {
            int parent = father.get(x);
            
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            int temp = -1;
            int fa = father.get(x);
            
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa,parent); // 重點，把路徑上的點都指向最上層的父節點
                fa = temp;
            }
            
            return parent;
        }
        
        void union(int x, int y) {
            int fa_x = find(x);
            int fa_y = find(y);
            
            if (fa_x != fa_y) {
                father.put(fa_y, fa_x);
            }
        }
        
        List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n) {
            
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        
            for (int i : hashSet) {
                int fa = uf.find(i);
                
                //找不到則建新的
                if (!hashMap.containsKey(fa)) {
                    hashMap.put(fa, new ArrayList<Integer>());
                }
                
                List<Integer> now = hashMap.get(fa);
                now.add(i);
                hashMap.put(fa, now);
            }
            
            for (List<Integer> now: hashMap.values()) {
                Collections.sort(now);
            }
            
            return res;
        }
    }
    
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        for (DirectedGraphNode now : nodes) {
            hashSet.add(now.label);
            
            for (DirectedGraphNode neighbor : now.neighbors) {
                hashSet.add(neighbor.label);
            }
        }
        
        UnionFind uf = new UnionFind(hashSet);
        
        for (DirectedGraphNode now : nodes) {
            
            for (DirectedGraphNode neighbor : now.neighbors) {
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
