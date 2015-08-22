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
    
    private int get(String a, int base) {
        if (a.equals("+") || a.equals("-")) {
            return 1 + base;
        }
        
        if (a.equals("*") || a.equals("/")) {
            return 2 + base;
        }
        
        return Integer.MAX_VALUE;
    }
    
    private void dfs(TreeNode root, ArrayList<String> as) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, as);
        }
        if (root.right != null) {
            dfs(root.right,as);
        }
        as.add(root.s);
    }
    
    private int evalReversePolish(String[] tokens) {
        int result = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(s);
            } else {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                
                switch (s) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                }
            }
        }
        
        if (stack.isEmpty()) {
            result = 0;
        } else {
            result = Integer.valueOf(stack.pop());
        }
        
        return result;
    }
    
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        
        if (expression == null || expression.length == 0) {
            return 0;
        }
        
        int len = expression.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        int val = 0;
        int base = 0;
        
        for (int i = 0; i <= len; i++) {
            
            if (i != len) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
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
        
        ArrayList<String> reversePolish = new ArrayList<String>();
        dfs(stack.peek().left, reversePolish);
        String[] str = new String[reversePolish.size()];
        reversePolish.toArray(str);
        
        return evalReversePolish(str);
    }
};
