/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==1) return 1;
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            l.add(new int[]{intervals.get(i).start,1});
            l.add(new int[]{intervals.get(i).end,-1});
        }
        l.sort((a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int rm=0, res=0;
        for(int[] i : l){
            rm+=i[1];
            res=Math.max(rm,res);
        }
        return res;
    }
}
