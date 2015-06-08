/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        
        pushLeftFrontier(root, stack);
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.right == null || node.right == prev) {
                list.add(node.val);
                prev = stack.pop();
            } else {
                pushLeftFrontier(node.right, stack);
            }
        }
        
        return list;
    }
    
    private void pushLeftFrontier(TreeNode node, Stack<TreeNode> stack) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    

}