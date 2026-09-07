class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] ed : edges){
            l.get(ed[0]).add(ed[1]);
            l.get(ed[1]).add(ed[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> hs = new HashSet<>();
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int curr = q.poll();
                // if(hs.contains(curr)) return false;
                hs.add(curr);
                for(int nei : l.get(curr)){
                    if(hs.contains(nei)) continue;
                    q.add(nei);
                }
            }
        }
        return hs.size()==n;
    }
}
