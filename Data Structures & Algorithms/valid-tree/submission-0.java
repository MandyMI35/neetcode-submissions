class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length>n-1) return false;
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> vst = new HashSet<>();
        if (!dfs(0, -1, vst, l)) return false;
        return vst.size()==n;
    }
    public boolean dfs(int node, int parent, Set<Integer> vst, List<List<Integer>> l){
        if(vst.contains(node)){
            return false;
        }
        vst.add(node);
        for(int neig : l.get(node)){
            if(neig==parent) continue;
            if (!dfs(neig, node, vst, l)) return false;
        }
        return true;
    }
}
