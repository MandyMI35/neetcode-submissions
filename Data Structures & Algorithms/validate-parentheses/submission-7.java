class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> h = new HashMap<>();
        h.put('(',')');
        h.put('{','}');
        h.put('[',']');
        for(int i=0;i<s.length();i++){
            if(h.containsKey(s.charAt(i))){
                st.push(s.charAt(i));
                continue;
            } else {
                if(st.empty()){return false;}
                char q = s.charAt(i);
                char w = st.pop();
                if(q!=h.get(w)){return false;}
            }
        }
        return st.empty() ? true : false;
    }
}
