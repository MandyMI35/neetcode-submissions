class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']+=1;
        }
        PriorityQueue<Integer> mh =new PriorityQueue<>(Collections.reverseOrder());
        for(int i: freq){
            if(i>0){
                mh.add(i);
            }
        }
        int time=0;
        Queue<int[]> q = new LinkedList<>();
        while(!mh.isEmpty() || !q.isEmpty()){
            time++;
            if(mh.isEmpty()){
                time = q.peek()[1];
            } else {
                int cnt = mh.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt, time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1]==time){
                mh.add(q.poll()[0]);
            }
        }
        return time;
    }
}
