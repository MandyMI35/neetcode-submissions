class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> h = new HashMap<>();
        h.put('(',')');
        h.put('{','}');
        h.put('[',']');
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(h.containsKey(s.charAt(i))){
                st.push(h.get(s.charAt(i)));
            } else {
                if(!st.isEmpty() && s.charAt(i)==st.pop()) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}
