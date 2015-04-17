/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        addToList(root,0,list);
        return list;
    }
    
    public void addToList(TreeNode root, int level, List<List<Integer>> list){
        if(root == null) return;
        if(list.size()-1 <level)
            list.add(0,new ArrayList<Integer>());
        list.get(list.size() - level -1).add(root.val);
        addToList(root.left, level+1, list);
        addToList(root.right, level+1, list);
    }
}