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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listOfResult = new ArrayList<List<Integer>>();
        addToList(root,listOfResult,0);
        return listOfResult;
    }
    
    public void addToList(TreeNode node, List<List<Integer>> list, int depth){
        if(node == null) return;
        if(list.size()<=depth)
            list.add(new ArrayList<Integer>());
        list.get(depth).add(node.val);
        addToList(node.left,list,depth+1);
        addToList(node.right,list,depth+1);
    }
}