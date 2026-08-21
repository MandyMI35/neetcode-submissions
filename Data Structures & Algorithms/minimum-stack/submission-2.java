class MinStack {
    Stack<Integer> s;
    ArrayList<Integer> l;
    public MinStack() {
        s=new Stack<>();
        l=new ArrayList<>();
    }
    
    public void push(int val) {
        s.push(val);
        l.add(val);
    }
    
    public void pop() {
        l.remove(s.pop());
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return Collections.min(l);
    }
}
