class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> l = new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            int u=edg[0], v=edg[1];
            l.get(u).add(v);
            l.get(v).add(u);
            boolean[] visit = new boolean[n+1];
            if(dfs(-1,u,l,visit)) return edg;
        }
        return new int[0];
    }
    public boolean dfs(int parent, int node, List<List<Integer>> l, boolean[] vst){
        if (vst[node]==true) return true;
        vst[node]=true;
        for(int neig : l.get(node)){
            if(neig==parent) continue;
            if(dfs(node, neig, l, vst)) return true;
        }
        return false;
    }
}
