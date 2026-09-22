class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<n;j++){
                int x2=points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i,k->new ArrayList<>())
                .add(new int[]{dist,j});
                adj.computeIfAbsent(j,k->new ArrayList<>())
                .add(new int[]{dist,i});
            }
        }
        int res=0;
        Set<Integer> vst = new HashSet<>();
        PriorityQueue<int[]> minh = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minh.offer(new int[]{0,0});
        while(vst.size()<n){
            int[] cur = minh.poll();
            int cost = cur[0];
            int i=cur[1];
            if(vst.contains(i)) continue;
            res+=cost;
            vst.add(i);
            for(int[] nei : adj.getOrDefault(i, Collections.emptyList())){
                int neic = nei[0];
                int neii = nei[1];
                if(!vst.contains(neii)) minh.offer(new int[]{neic, neii});
            }
        }
        return res;
    }
}
