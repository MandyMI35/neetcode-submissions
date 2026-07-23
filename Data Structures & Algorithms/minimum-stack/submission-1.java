class MinStack {
    Stack<Integer> s;
    Stack<Integer> ms = new Stack<>();
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(ms.empty() || val<=ms.peek()){
            ms.push(val);
        }
    }
    
    public void pop() {
        int k = s.pop();
        if(k==ms.peek()){
            k=ms.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}
