class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] ind = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){adj.add(new ArrayList<>());}
        for(int[] ed : edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
            ind[ed[0]]++;
            ind[ed[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(ind[i]==1) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ind[curr]--;
            for(int nei : adj.get(curr)){
                ind[nei]--;
                if(ind[nei]==1) q.offer(nei);
            }
        }
        for(int i=edges.length-1;i>-1;i--){
            if(ind[edges[i][0]]>0 && ind[edges[i][1]]>0) return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[0];
    }
    
}
