/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            serialize(root, sb);
        }
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        //加空白是為了tokenizer可以把結果分開來parse
        if (node == null) {
            sb.append("# ");
        } else {
            sb.append(node.val + " ");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.length() == 0) {
            return null;
        }
        //轉成tokenizer使用空白把值分開
        StringTokenizer st = new StringTokenizer(data);
        TreeNode root = deserialize(st);
        return root;
    }
    
    private TreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        
        return root;
    }
}

