class Solution {
    List<List<String>> l = new ArrayList<>();
    public List<List<String>> partition(String s) {
        rec(s,0,new ArrayList<>());
        return l;
    }
    public void rec(String s, int st, List<String> curr){
        if(st>=s.length()){
            l.add(new ArrayList<>(curr));
            return;
        }
        for(int i=st;i<s.length();i++){
            if(palind(s.substring(st,i+1))){
                curr.add(s.substring(st,i+1));
                rec(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean palind(String s){
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
