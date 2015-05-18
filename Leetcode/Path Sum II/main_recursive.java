public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        
        //use stack to record the path
        Stack<Integer> path = new Stack<Integer>();
        //Remember!! Do not forget to return final result.
        pathSumHelper(root, sum, path);
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int current, Stack<Integer> path){
        //push current node into stack.
        path.push(root.val);
        
        //if reached leaf node
        if(root.right==null && root.left==null){
            if (root.val==current)
                result.add(new ArrayList<Integer>(path));
        }
        if(root.left != null) pathSumHelper(root.left, current-root.val, path);
        if(root.right != null) pathSumHelper(root.right, current-root.val, path);
        
        path.pop();
    }
}