/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
     
    public class UnionFind {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        public UnionFind(int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int idx = convertIdx(i, j, m);
                    map.put(idx, idx);
                }
            }
        }
        
        public int find(int x) {
            int parent = map.get(x);
            while (parent != map.get(parent)) {
                parent = map.get(parent);
            }
            
            return parent;
        }
        
        public void Union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            
            if (parentX != parentY) {
                map.put(x, parentY);
            }
        }
    }
    
    public int convertIdx(int i, int j, int m) {
            return i * m + j;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        
        
        List<Integer> res = new ArrayList<Integer>();
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] isIsland = new int[n][m];
        int count = 0;
        UnionFind uf = new UnionFind(n, m);
        
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            int index = convertIdx(x, y, m);
            
            isIsland[x][y] = true;
            count++;
            
            for (int j = 0; j < directions.length; j++) {
                int newX = x + directions[j].x;
                int newY = y + directions[j].y;
                int newIndex = convertIdx(newX, newY, m);
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (isIsland[newX][newY]) {
                        int father = uf.find(index);
                        int neighborFather = uf.find(newIndex);
                        if (father != neighborFather) {
                            count--;
                            uf.union(index, newIndex);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
