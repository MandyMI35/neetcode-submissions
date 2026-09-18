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
        int[] st = new int[intervals.size()];
        int[] ed = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            st[i]=intervals.get(i).start;
            ed[i]=intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(ed);
        int s=0,e=0;
        int res=0, rm=0;
        while(s!=st.length && e!=st.length){
            if(st[s]<ed[e]){
                s++;
                rm++;
                res=Math.max(res,rm);
            } else if(st[s]>=ed[e]){
                e++;
                rm--;
            }
        }
        return res;
    }
}
