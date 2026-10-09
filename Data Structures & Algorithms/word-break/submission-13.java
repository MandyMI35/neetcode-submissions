class Solution {
    HashMap<Integer, Boolean> h;
    public boolean wordBreak(String s, List<String> wordDict) {
        h = new HashMap<>();
        h.put(s.length(),true);
        return dfs(s,wordDict,0);
    }
    public boolean dfs(String s, List<String> wd, int i){
        if(h.containsKey(i)) return h.get(i);
        for(String w : wd){
            if(i+w.length()<=s.length() && 
            s.substring(i,i+w.length()).equals(w)){
                if(dfs(s,wd,i+w.length())){
                    h.put(i,true);
                    return true;
                }
            }
        }
        h.put(i,false);
        return false;
    }
}
