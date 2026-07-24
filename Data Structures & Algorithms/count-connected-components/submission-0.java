class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> s = new HashSet<>();
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] ed : edges){
            l.get(ed[0]).add(ed[1]);
            l.get(ed[1]).add(ed[0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!s.contains(i)){
                dfs(i,s,l);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node, HashSet<Integer> s, List<List<Integer>> l){
        if(!s.contains(node)) s.add(node);
        for(int neig : l.get(node)){
            if(!s.contains(neig)){
                dfs(neig,s,l);
            }
        }
    }
}
