class MinStack {
    Stack<Integer> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
    }
    
    public void pop() {
        if(!s.empty()){
            int m = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        int minm=Integer.MAX_VALUE;
        Stack<Integer> st = new Stack<>();
        while(!s.empty()){
            int y = s.pop();
            st.push(y);
            minm=Math.min(y,minm);
        }
        while(!st.empty()){
            s.push(st.pop());
        }
        return minm;
    }
}
