class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind= new int[numCourses];
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            l.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            ind[pre[0]]++;
            l.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i]==0) q.add(i);
        }
        int[] res = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            res[i]=curr;
            i++;
            for(int nei : l.get(curr)){
                ind[nei]--;
                if(ind[nei]==0) q.add(nei);
            }
        }
        return i!=numCourses ? new int[0] : res;
    }
}
