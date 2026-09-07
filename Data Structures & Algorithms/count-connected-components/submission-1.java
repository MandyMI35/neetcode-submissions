class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> l =  new ArrayList<>();
        for(int i=0;i<n;i++){l.add(new ArrayList<>());}
        for(int[] ed : edges){
            l.get(ed[0]).add(ed[1]);
            l.get(ed[1]).add(ed[0]);
        }
        HashSet<Integer> hs = new HashSet<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!hs.contains(i)){
                cnt++;
                dfs(l,hs,i);
            }
        }
        return cnt;

    }
    public void dfs(List<List<Integer>> l, HashSet<Integer> vstd, int i){
        if(vstd.contains(i)) return;
        vstd.add(i);
        for(int nei : l.get(i)){
            dfs(l,vstd,nei);
        }
    }
}
