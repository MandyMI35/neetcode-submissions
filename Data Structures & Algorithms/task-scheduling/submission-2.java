class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks) count[task-'A']++;
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt :count){
            if(cnt>0) mh.add(cnt);
        }
        int time=0;
        Queue<int[]> q= new LinkedList<>();
        while(!mh.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty() && q.peek()[1]==time) mh.add(q.poll()[0]);
            time++;
            if(mh.isEmpty()) time = q.peek()[1];
            else {
                int cnt = mh.poll()-1;
                if (cnt>0) q.add(new int[]{cnt, time+n});
            }
        }
        return time;
    }
}
