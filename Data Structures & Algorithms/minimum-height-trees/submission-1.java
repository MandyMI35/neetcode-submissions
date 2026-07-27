class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return List.of(0);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            l.add(new ArrayList<>());
        }
        for(int[] ed : edges){
            l.get(ed[0]).add(ed[1]);
            l.get(ed[1]).add(ed[0]);
        }
        int[] edgecnt = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for(int i=0;i<n;i++){
            edgecnt[i] = l.get(i).size();
            if(edgecnt[i]==1) leaves.add(i);
        }
        while (!leaves.isEmpty()){
            if(n<=2) return new ArrayList<>(leaves);
            int size = leaves.size();
            for(int i=0; i<size;i++){
                int node = leaves.poll();
                n--; // to track remaning nodes in entire tree and not just leaves
                for(int neig : l.get(node)){
                    edgecnt[neig]--;
                    if (edgecnt[neig] == 1) leaves.add(neig);
                }
            }
        }
        return new ArrayList<>();
    }
}