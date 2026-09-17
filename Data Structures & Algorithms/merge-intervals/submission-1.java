class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> l = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] nxt = intervals[i];
            if(cur[1]<nxt[0]){
                l.add(cur);
                cur=nxt;
            } else {
                cur[0]=Math.min(cur[0],nxt[0]);
                cur[1]=Math.max(cur[1],nxt[1]);
            }
        }
        l.add(cur);
        return l.toArray(new int[l.size()][]);
    }
}
