class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(!"+/*-".contains(s)) st.push(Integer.parseInt(s));
            else{
                int a=st.pop(), b=st.pop();
                if(s.equals("+")) st.push(a+b);
                else if(s.equals("*")) st.push(a*b);
                else if(s.equals("-")) st.push(b-a);
                else if(s.equals("/")) st.push(b/a);
            }
        }
        return st.pop();
    }
}
