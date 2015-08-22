public class Solution {
    
    class TreeNode {
        int val;
        String s;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val, String s) {
            this.val = val;
            this.s = s;
            this.left = null;
            this.right = null;
        }
    }
    
    private int get(String s, int base) {
        // 因是build min tree，所以優先權要反過來想
        // 通常加減是在乘除後面作的，所以給予較高的優先值
        // 之後在樹中才會在較上層的地位
        if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        } else if (s.equals("*") || s.equals("/")) {
            return 2 + base;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    private void dfs(TreeNode root, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, res);
        }
        
        if (root.right != null) {
            dfs(root.right, res);
        }
        res.add(root.s);
    }
    
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        
        ArrayList<String> res = new ArrayList<String>();
        
        if (expression == null || expression.length == 0) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int val = 0;
        int base = 0;
        int len = expression.length;
        
        for (int i = 0; i <= len; i++) {
            
            //此處用來設定base與設定該運算元與運算子的優先權，
            if (i != len) {
                
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                } else if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                
                val = get(expression[i], base);
            }
            
            TreeNode right;
            if (i == len) {
                right = new TreeNode(Integer.MIN_VALUE, "");
            } else {
                right = new TreeNode(val, expression[i]);
            }
    
            while (!stack.isEmpty()) {
                
                if (right.val <= stack.peek().val) {
                    TreeNode nodeNow = stack.pop();
                    
                    if (stack.isEmpty()) {
                        right.left = nodeNow;
                    } else {
                        TreeNode left = stack.peek();
                        // 在這要決定當前node的parent是誰，
                        // 因是min tree，但為了之後更小的節點可以當樹上層的節點
                        // 因此我們選擇了兩者較大的一個
                        if (left.val < right.val) {
                            right.left = nodeNow;
                        } else {
                            left.right = nodeNow;
                        }
                    }
                } else {
                    break;
                }
            }
            
            stack.push(right);
        }
        
        dfs(stack.peek().left, res);
        
        return res;
    }
}
