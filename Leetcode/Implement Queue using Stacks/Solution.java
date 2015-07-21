class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stackOne = new Stack<Integer>();
    Stack<Integer> stackTwo = new Stack<Integer>();
    public void push(int x) {
        stackOne.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stackTwo.isEmpty()) {
            stackTwo.pop();
        }else {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            stackTwo.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (!stackTwo.isEmpty()) {
            return stackTwo.peek();
        }else {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}