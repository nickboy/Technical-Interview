public class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public Solution() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    // 另外再建一個minStack來存放當下最小的值，每次插入都與minStack最上面那個比較，
    // 若較小或相等則，push進去minStack
    // 若較大，則不處理
    // 記得處理空stack的狀態
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public int pop() {
        int number = -1;
        if (!stack.isEmpty()) {
            number = stack.pop();
            if (!minStack.isEmpty() && number == minStack.peek()) {
                minStack.pop();
            }
        }
        return number;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}

