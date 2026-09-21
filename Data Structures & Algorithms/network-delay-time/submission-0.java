class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> ed = new HashMap<>();
        for(int[] t : times){
            ed.computeIfAbsent(t[0], 
            key -> new ArrayList<>()).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> minh = new PriorityQueue<>(
            Comparator.comparingInt(a->a[0]));
        minh.offer(new int[]{0,k});
        Set<Integer> vstd = new HashSet<>();
        int t=0;
        while(!minh.isEmpty()){
            int[] cur = minh.poll();
            int w1 = cur[0], n1 = cur[1];
            if(vstd.contains(n1)) continue;
            vstd.add(n1);
            t=w1;
            if(ed.containsKey(n1)){
                for(int[] nxt : ed.get(n1)){
                    int n2 = nxt[0], w2=nxt[1];
                    if(!vstd.contains(n2)) minh.offer(new int[]{w1+w2,n2});
                }
            }
        }
        return vstd.size() == n ? t : -1;
    }
}
