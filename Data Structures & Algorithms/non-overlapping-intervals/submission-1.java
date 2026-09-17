class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int res=0;
        int prevend = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s>=prevend) prevend=e;
            else {
                res++;
                prevend = Math.min(e,prevend);
            }
        }
        return res;
    }
}
