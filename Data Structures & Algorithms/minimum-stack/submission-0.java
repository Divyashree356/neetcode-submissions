class MinStack {

    public List<Integer> stack;
    int min;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.add(0 ,val);
        min = Math.min(min, val);
    }

    public void pop() {

        int v = stack.get(0);
        stack.remove(0);

        if (stack.size() == 0) min = Integer.MAX_VALUE;;

        if (min == v && stack.size() != 0) {
            min = stack.get(0);
            for(int n : stack) min = Math.min(min, n);
        }
    }

    public int top() {
        return stack.get(0);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */