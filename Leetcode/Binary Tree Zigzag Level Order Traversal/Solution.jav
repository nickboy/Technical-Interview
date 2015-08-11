/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            res.add(new ArrayList<Integer>(lsit));
        }
        
        for (int i = 1; i < res.size(); i = i + 2) {
            List<Integer> list = reverse(res.get(i));
            res.set(i, list);
        }
        return res;
    }
    
    private List<Integer> reverse(List<integer> list) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
        return list;
    }
}